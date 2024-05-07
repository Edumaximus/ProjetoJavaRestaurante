package file_manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileManager{

    /*Variáveis e método para setar o diretório base, para que o código funcione em qualquer máquina que baixe*/
    private static final String BASE_DIRECTORY = "ProjetoJavaRestaurante";
    private String filePath;

    public FileManager(String relativeFilePath) {
        this.filePath = Paths.get(BASE_DIRECTORY, relativeFilePath).toString();
    }

    //Método de leitura de informações de funcionários
    public static void leituraFuncionarios(int idFuncionario) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new FileReader("file_manager/dadosFuncionario.txt"));
        String linha = "";

        //Split divide as linhas usando vírgula, e retorna cada parte como uma posição de array
        while ((linha = bufferedReader.readLine()) != null){
            var aaa = linha.split(",");
            if(Integer.parseInt(aaa[0].toString()) == idFuncionario){
                String nome = aaa[1];
                String posicao = aaa[2];
                String cpf = aaa[3];
                Double salario = Double.parseDouble(aaa[4]);

                System.out.println("Nome: "+nome+" Posição: "+posicao+" Documento: "+cpf+" Salário: R$"+salario+"\n");
            }
        }
    }

    //Método para obter o próximo id de Pedido
    public static int proxId() throws IOException{
        int proxId = 0;

        BufferedReader bufferedReader = new BufferedReader(new FileReader("file_manager/pedidos.txt"));
        String linha = "";

        while ((linha = bufferedReader.readLine()) != null){
            
            //Código mais complexo para lidar com os espaços e linhas em branco do arquivo pedidos
            linha = linha.trim();
            if (linha.trim().isEmpty()) {
                continue;
            }
            String[] aaa = linha.split("\\s*,\\s*");
            
            // Transforma o primeiro elemento do array em int e adiciona 1, seta o valor novo de proxId
            proxId = Integer.parseInt(aaa[0])+1;
        }
        return proxId;
    }

    //Método que recebe o id dos pratos do pedido, vê o valor de cada um no arquivo de cardápio e soma os valores pra colocar no pedido
    public static Double calculoPreco(int idPrato1, int idPrato2) throws NumberFormatException, IOException{
        BufferedReader bufferedReader = new BufferedReader(new FileReader("file_manager/cardapio.txt"));
        String linha = "";
        Double preco1 = 0.0;
        Double preco2 = 0.0;

        while ((linha = bufferedReader.readLine()) != null){
            var aaa = linha.split(",");
            if(Integer.parseInt(aaa[0].toString()) == idPrato1){
                preco1 = Double.parseDouble(aaa[2]);
            }else if(Integer.parseInt(aaa[0].toString()) == idPrato2){
                preco2 = Double.parseDouble(aaa[2]);
            }
        }

        Double precoTotal=preco1+preco2;
        return precoTotal;
    }

    //Método pra salvar o pedido recém feito em uma nova linha no arquivo de pedidos
    public static void salvarPedido(int idPedido, int idPrato1, int idPrato2, Double precoTotal, int mesa) throws IOException {

        //Append é usado para ter certeza que o programa vai escrever uma linha nova sem apagar as anteriores
        FileWriter fileWriter = new FileWriter("file_manager/pedidos.txt", true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(idPedido+","+idPrato1+","+idPrato2+","+precoTotal+","+mesa+"\n");
        printWriter.flush();
        printWriter.close();
        System.out.println("Pedido "+idPedido+" salvo, valor: R$"+precoTotal+"\n");
    }

    //Método para checar se o pagamento de um pedido está correto, e fornecer o valor do troco, se houver
    public static void checarPagto(int idPedidoPagto, Double valor) throws NumberFormatException, IOException{
        BufferedReader bufferedReader = new BufferedReader(new FileReader("file_manager/pedidos.txt"));
        String linha = "";

        while ((linha = bufferedReader.readLine()) != null){
            
            //Mesmo código anteriormente mencionado para lidar com espcaços e linhas em branco
            linha = linha.trim();
            if (linha.trim().isEmpty()) {
                continue;
            }
            String[] aaa = linha.split("\\s*,\\s*");

            if(Integer.parseInt(aaa[0].toString()) == idPedidoPagto){
                if (Double.parseDouble(aaa[3]) == valor) {

                    System.out.println("Pagamento efetuado com sucesso!\n");
                }else if(Double.parseDouble(aaa[3]) < valor){
                    Double troco;
                    troco = valor - Double.parseDouble(aaa[3]);

                    System.out.println("Pagamento efetuado com sucesso, troco: R$"+troco+"\n");
                }else{
                    System.out.println("Pagamento insuficiente, favor tentar novamente.\n");
                }
            }
        }
    }

    //Método para remover um prato do cardápio
    public static void deleteMenuItem(int id) {
        File inputFile = new File("file_manager/cardapio.txt");
        File tempFile = new File("file_manager/tempcardapio.txt");

        //Código para copiar todas as linhas do cardápio para um arquivo temporário, exceto a linha do prato a ser removido
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String lineToRemove = String.format("%04d,", id);
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {

                // Se a linha atual não começa com o ID do prato a ser removido, escreve no arquivo temporário
                if (!currentLine.startsWith(lineToRemove)) {
                    writer.write(currentLine + System.getProperty("line.separator"));
                }
            }

            writer.close();
            reader.close();

            // Substitui o arquivo original pelo arquivo temporário
            inputFile.delete();
            tempFile.renameTo(inputFile);

            System.out.println("Prato removido com sucesso!\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Método para ver somente o nome dos pratos do arquivo cardápio
    public static void lerPratos(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("file_manager/cardapio.txt"));
            String line;

            //Imprime a segunda parte do split a cada linha como nome
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    String name = parts[1];
                    System.out.println(name);
                }
            }
            System.out.println("\n");

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //Método para ver somente o nome dos pratos do arquivo cardápio, em ordem alfabética
    public static void lerPratosAlfabetica() {
        ArrayList<String> names = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("file_manager/cardapio.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    String name = parts[1];
                    names.add(name);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Ordena os nomes em ordem alfabética
        Collections.sort(names);
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("\n");
    }
}