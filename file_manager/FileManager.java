package ProjetojavaRestaurante.file_manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileManager {

    public static void main(String[] args) throws IOException {
        // Criação de diretório e arquivo
        File dir = new File("file_manager");
        File arq = new File(dir, "DadosFuncionario.txt");
        arq.createNewFile();

        FileWriter fileWriter = new FileWriter(arq, false);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        // código para escrever no arquivo
        printWriter.println("Conteúdo do arquivo default.txt");
        printWriter.flush();
        printWriter.close();

        // código para ler o arquivo
        File arquivoLeitura = new File("file_manager\\DadosFuncionario.txt");
        try (Scanner leitor = new Scanner(arquivoLeitura)) {
            while (leitor.hasNextLine()) {
                System.out.println(leitor.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
            e.printStackTrace();
        }

        public void leituraFuncionarios(int idFuncionario){
            BufferedReader bufferedReader = new BufferedReader(file_manager,DadosFuncionario.txt);
            String linha = "";

            while ((linha = bufferedReader.readLine()) != null){
                var aaa = linha.split(",");
                aaa[0] == 554
            }
        }
    }
}

