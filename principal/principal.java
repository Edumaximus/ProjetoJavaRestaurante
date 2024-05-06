package principal;

import java.io.IOException;
import java.util.Scanner;

import file_manager.FileManager;
import models.Cardapio;
import models.Cliente;
import models.Funcionario;
import models.Pedido;

public class principal {

    //Criação do método principal
    public static void main(String[] args) throws IOException {
     //Menu do sistema
        System.out.println("++++++++++++++++++++++++++++++++++\n");
        System.out.println("Sistema de controle de restaurante\n");
        System.out.println("Selecione a operação");
        System.out.println("A: Registrar cliente");
        System.out.println("B: Registrar pedido");
        System.out.println("C: Registrar pagamento");
        System.out.println("D: Registrar prato");
        System.out.println("E: Ver informações de funcionário");
        System.out.println("++++++++++++++++++++++++++++++++++\n");

        //Seletor de alternativa
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();

        //Código pra chamar os métodos presentes nas classes (métodos ainda por fazer)
        switch (option) {
            case "A":
                System.out.println("Escreva o nome e a mesa a ocupar:\n");
                String nome = scanner.nextLine();
                int numeroMesa = scanner.nextInt();
                Cliente cliente = new Cliente(nome, numeroMesa);
                break;

            case "B":
                System.out.println("Selecione dois pratos usando o ID do cardápio (Digite 0000 para pular um prato), e depois selecione a mesa\n");
                int idPrato1 = scanner.nextInt();
                int idPrato2 = scanner.nextInt();
                int mesa = scanner.nextInt();
                Pedido pedido = new Pedido(idPrato1, idPrato2, mesa);
                break;

            case "C":
                //Este método deve checar e executar o pagamento, e gerar um arquivo de recibo usando o filemanager
                /*System.out.println("Escreva a mesa que realizará o pagamento e o valor coletado: \n");
                int idPedidoPagto = scanner.nextInt();
                Double valor = scanner.nextDouble();
                Pedido.pagar(idPedidoPagto, valor);*/
                break;

            case "D":
                //Esse método deve ser usado em conjunto com o filemanager, para acessar um arquivo de lista de pratos e adicionar uma linha nova
                /*System.out.println("Digite o id, nome e preço do novo prato: ");
                int idPrato = scanner.nextInt();
                String nomePrato = scanner.nextLine();
                Double precoPrato = scanner.nextDouble();
                Cardapio prato = new Cardapio();*/
                break;

            case "E" :
            
                System.out.println("digite o Id do Funcionário para mais informações");
                int idFuncionario = scanner.nextInt();
                Funcionario.lerInformacoes(idFuncionario);
                break;
            default:
                break;
        }

        //System.out.println("Deseja fazer outra operação?\n");
        
        scanner.close();
    }
}
