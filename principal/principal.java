package principal;

import java.util.Scanner;

import file_manager.FileManager;
import models.Cardapio;
import models.Cliente;
import models.Funcionario;
import models.Pedido;

public class principal {

    //Criação do método principal
    public static void main(String[] args) {
     //Menu do sistema
        System.out.println("++++++++++++++++++++++++++++++++++\n");
        System.out.println("Sistema de controle de restaurante\n");
        System.out.println("Selecione a operação");
        System.out.println("A: Registrar cliente");
        System.out.println("B: Registrar pedido");
        System.out.println("C: Entregar pedido");
        System.out.println("D: Registrar pagamento");
        System.out.println("E: Registrar prato");
        System.out.println("F: Registrar funcionário");
        System.out.println("G: Começar/Terminar turno de funcionário");
        System.out.println("H: Pagar salário de funcionário");
        System.out.println("I: Registrar aumento de funcionário");
        System.out.println("J: Demitir funcionário");
        System.out.println("K: Acessar arquivos\n");
        System.out.println("++++++++++++++++++++++++++++++++++\n");

        //Seletor de alternativa
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();

        //Código pra chamar os métodos presentes nas classes (métodos ainda por fazer)
        switch (option) {
            case "A":
                Cliente.cliente();
                break;

            case "B":
                Pedido.pedido();
                break;

            case "C":
                Pedido.entregar();
                break;

            case "D":
                Cliente.pagar();
                break;

            case "E":
                Cardapio.registrarPrato();
                break;

            case "F":
                Funcionario.funcionario();
                break;

            case "G":
                Funcionario.baterPonto();
                break;

            case "H":
                Funcionario.pagarSalario();
                break;

            case "I":
                Funcionario.aumento();
                break;

            case "J":
                Funcionario.Demitir();
                break;

            case "K":
                FileManager.viewDocs();
                break;
        
            default:
                break;
        }

        //System.out.println("Deseja fazer outra operação?\n");
        
        scanner.close();
    }
}
