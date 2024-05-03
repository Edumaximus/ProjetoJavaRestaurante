package file_manager;

import java.io.BufferedReader;
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
}

