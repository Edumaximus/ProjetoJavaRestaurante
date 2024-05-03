package file_manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileManager{

    //A completar.
    public static void leituraFuncionarios(int idFuncionario) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new FileReader("ProjetoJavaRestaurante\\file_manager\\dadosFuncionario.txt"));
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

    public void adicionarItem(String novoItem, String cardapio.txt) throws IOException {
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
    }
}


