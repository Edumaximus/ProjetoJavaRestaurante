package file_manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileManager throws IOException FileNotFoundException; {
    
//código de criação de arquivos básico
    FileWriter arquivo = new FileWriter("file_manager\\arquivoDefault.txt");
    PrintWriter gravador = new PrintWriter(arquivo);

    //Criação de diretório e arquivo
    File dir = new File("file_manager");
    File arq = new File(dir, "default.txt");
    arq.createNewFile();

    FileWriter fileWriter = new FileWriter(arq, false);

    PrintWriter printWriter = new PrintWriter(fileWriter);

    //código de o que colocar no arquivo vai aqui

    printWriter.flush();

    printWriter.close();

//código de leitura de arquivos básico

    /*File dir = new File("C:\\TutorialArquivos");
    File arq = new File(dir, "User.txt");
    // Indicamos o arquivo que será lido
    FileReader fileReader = new FileReader(arq);
    // Criamos o objeto bufferReader que nos
    // oferece o método de leitura readLine()
    BufferedReader bufferedReader = new BufferedReader(fileReader);
    // String que irá receber cada linha do arquivo
    String linha = "";
    // Fazemos um loop linha a linha no arquivo,
    // enquanto ele seja diferente de null.
    // O método readLine() devolve a linha na
    // posicao do loop para a variavel linha.
    while ( ( linha = bufferedReader.readLine() ) != null) {
    //Aqui imprimimos a linha
    System.out.println(linha);
    }
    //liberamos o fluxo dos objetos ou fechamos o arquivo
    fileReader.close();
    bufferedReader.close();*/

    File arquivoLeitura = new File("file_manager\\\\arquivoDefault.txt");
    Scanner leitor = new Scanner(arquivoLeitura);

    while (leitor.hasNext()){
        System.out.println(leitor.nextLine());
    }

}
