package file_manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

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

                System.out.println("Nome: "+nome+" Posição: "+posicao+" Documento: "+cpf+" Salário: R$"+salario);
                
            }
        }
    }

    /*public static Double calculoPreco(int idPrato1, int idPrato2) throws NumberFormatException, IOException{
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\eduar\\Desktop\\Análise e desenvolvimento de sistemas\\3º Semestre\\Desenvolvimento de software\\Trabalhos\\ProjetoJavaRestaurante\\file_manager\\pedidos.txt"));
        String linha = "";
        Double preco1 = 0.0;
        Double preco2 = 0.0;

        while ((linha = bufferedReader.readLine()) != null){
            var aaa = linha.split(",");
            if(Integer.parseInt(aaa[0].toString()) == idPrato1){
                preco1 = Double.parseDouble(aaa[3]);
            }
        }
        while ((linha = bufferedReader.readLine()) != null){
            var bbb = linha.split(",");
            if(Integer.parseInt(bbb[0].toString()) == idPrato2){
                preco2 = Double.parseDouble(bbb[3]);
            }
        }

        Double precoTotal=preco1+preco2;
        return precoTotal;
    }

    public static void salvarPedido(int idPedido, int idPrato1, int idPrato2, Double precoTotal, int mesa) throws IOException {
        FileWriter fileWriter = new FileWriter("C:\\Users\\eduar\\Desktop\\Análise e desenvolvimento de sistemas\\3º Semestre\\Desenvolvimento de software\\Trabalhos\\ProjetoJavaRestaurante\\file_manager\\pedidos.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);

        printWriter.println(idPedido+","+idPrato1+","+idPrato2+","+precoTotal+","+mesa);
        System.out.println("Pedido "+idPedido+" salvo, valor: R$"+precoTotal);
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


