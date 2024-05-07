package file_manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileManager{

    public static void leituraFuncionarios(int idFuncionario) throws IOException{
        //Caminho só funciona no meu pc, alterar para o seu se quiser testar
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\eduar\\Desktop\\Análise e desenvolvimento de sistemas\\3º Semestre\\Desenvolvimento de software\\Trabalhos\\ProjetoJavaRestaurante\\file_manager\\dadosFuncionario.txt"));
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

        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\eduar\\Desktop\\Análise e desenvolvimento de sistemas\\3º Semestre\\Desenvolvimento de software\\Trabalhos\\ProjetoJavaRestaurante\\file_manager\\pedidos.txt"));
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
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\eduar\\Desktop\\Análise e desenvolvimento de sistemas\\3º Semestre\\Desenvolvimento de software\\Trabalhos\\ProjetoJavaRestaurante\\file_manager\\cardapio.txt"));
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
        FileWriter fileWriter = new FileWriter("C:\\Users\\eduar\\Desktop\\Análise e desenvolvimento de sistemas\\3º Semestre\\Desenvolvimento de software\\Trabalhos\\ProjetoJavaRestaurante\\file_manager\\pedidos.txt", true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(idPedido+","+idPrato1+","+idPrato2+","+precoTotal+","+mesa+"\n");
        printWriter.flush();
        printWriter.close();
        System.out.println("Pedido "+idPedido+" salvo, valor: R$"+precoTotal+"\n");
    }

    public static void checarPagto(int idPedidoPagto, Double valor) throws NumberFormatException, IOException{
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\eduar\\Desktop\\Análise e desenvolvimento de sistemas\\3º Semestre\\Desenvolvimento de software\\Trabalhos\\ProjetoJavaRestaurante\\file_manager\\pedidos.txt"));
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

    /*public static void removerPrato(int idRemocao) throws IOException{
        File inputFile = new File("C:\\Users\\eduar\\Desktop\\Análise e desenvolvimento de sistemas\\3º Semestre\\Desenvolvimento de software\\Trabalhos\\ProjetoJavaRestaurante\\file_manager\\cardapio.txt");
        File tempFile = new File("C:\\Users\\eduar\\Desktop\\Análise e desenvolvimento de sistemas\\3º Semestre\\Desenvolvimento de software\\Trabalhos\\ProjetoJavaRestaurante\\file_manager\\tempcardapio.txt");
        String linha = "";

        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\eduar\\Desktop\\Análise e desenvolvimento de sistemas\\3º Semestre\\Desenvolvimento de software\\Trabalhos\\ProjetoJavaRestaurante\\file_manager\\cardapio.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\eduar\\Desktop\\Análise e desenvolvimento de sistemas\\3º Semestre\\Desenvolvimento de software\\Trabalhos\\ProjetoJavaRestaurante\\file_manager\\tempcardapio.txt"));

        while ((linha = reader.readLine()) != null){
            /* Remove any `possible` leading or trailing whitespaces, 
               tabs, etc from read file line:       
            linha = linha.trim();
            
               // Skip past blank file lines (if any):
            if (linha.trim().isEmpty()) {
                   continue;
            }
               
               /* Split the file data line.
            String[] aaa = linha.split("\\s*,\\s*");
            String trechoRemocao = (aaa[0]+","+aaa[1]+","+aaa[2]);

            String lineToRemove = trechoRemocao;
            String currentLine;

            while((currentLine = reader.readLine()) != null) {
                // trim newline when comparing with lineToRemove
                String trimmedLine = currentLine.trim();
                if(trimmedLine.equals(lineToRemove)) continue;
                writer.write(currentLine + System.getProperty("line.separator"));
            } 
            boolean successful = tempFile.renameTo(inputFile);
        }

    }*/

    /*public void adicionarItem(String novoItem, String cardapio.txt) throws IOException {
        // Abre o arquivo existente para leitura e escrita
        FileReader fileReader = new FileReader("cardapio.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

        // Cria um FileWriter para escrever no final do arquivo
        FileWriter fileWriter = new FileWriter("cardapio.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        // Lê o arquivo e imprime os itens existentes
        String linha;
        while ((linha = bufferedReader.readLine()) != null) {
            System.out.println(linha);
        }

        // Adiciona o novo item ao arquivo
        bufferedWriter.write(novoItem);
            bufferedWriter.newLine();

        // Fecha 
        bufferedReader.close();
            bufferedWriter.close();

        System.out.println("Item adicionado com sucesso ao arquivo " + "cardapio.txt");
    }*/
}


