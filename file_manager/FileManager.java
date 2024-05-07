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

    private static final String BASE_DIRECTORY = "ProjetoJavaRestaurante";
    private String filePath;

    public FileManager(String relativeFilePath) {
        this.filePath = Paths.get(BASE_DIRECTORY, relativeFilePath).toString();
    }

    public static void leituraFuncionarios(int idFuncionario) throws IOException{
        //Caminho só funciona no meu pc, alterar para o seu se quiser testar
        BufferedReader bufferedReader = new BufferedReader(new FileReader("file_manager/dadosFuncionario.txt"));
        String linha = "";

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

    public static int proxId() throws IOException{
        int proxId = 0;

        BufferedReader bufferedReader = new BufferedReader(new FileReader("file_manager/pedidos.txt"));
        String linha = "";

        while ((linha = bufferedReader.readLine()) != null){
            /* Remove any `possible` leading or trailing whitespaces, 
               tabs, etc from read file line:       */
            linha = linha.trim();
            
            // Skip past blank file lines (if any):
            if (linha.trim().isEmpty()) {
                continue;
            }
            
            /* Split the file data line.*/
            String[] aaa = linha.split("\\s*,\\s*");
            
            // Convert the first String[] array element to `int` and add 1:
            proxId = Integer.parseInt(aaa[0])+1;
        }
        
        return proxId;
    }

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

    public static void salvarPedido(int idPedido, int idPrato1, int idPrato2, Double precoTotal, int mesa) throws IOException {
        FileWriter fileWriter = new FileWriter("file_manager/pedidos.txt", true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(idPedido+","+idPrato1+","+idPrato2+","+precoTotal+","+mesa+"\n");
        printWriter.flush();
        printWriter.close();
        System.out.println("Pedido "+idPedido+" salvo, valor: R$"+precoTotal+"\n");
    }

    public static void checarPagto(int idPedidoPagto, Double valor) throws NumberFormatException, IOException{
        BufferedReader bufferedReader = new BufferedReader(new FileReader("file_manager/pedidos.txt"));
        String linha = "";

        while ((linha = bufferedReader.readLine()) != null){
            /* Remove any `possible` leading or trailing whitespaces, 
               tabs, etc from read file line:       */
            linha = linha.trim();
            
               // Skip past blank file lines (if any):
            if (linha.trim().isEmpty()) {
                   continue;
            }
               
               /* Split the file data line.*/
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

    public static void deleteMenuItem(int id) {
        File inputFile = new File("file_manager/cardapio.txt");
        File tempFile = new File("file_manager/tempcardapio.txt");

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

    public static void lerPratos(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("file_manager/cardapio.txt"));
            String line;
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

        Collections.sort(names); // Ordena os nomes em ordem alfabética

        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("\n");
    }
}


