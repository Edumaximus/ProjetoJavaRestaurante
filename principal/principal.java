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
        
        Scanner scanner = new Scanner(System.in);

        int option;
        while (true) {
            System.out.println("++++++++++++++++++++++++++++++++++");
            System.out.println("Sistema de restaurante");
            System.out.println("1: Registrar cliente");
            System.out.println("2: Registrar pedido");
            System.out.println("3: Registrar pagamento");
            System.out.println("4: Registrar prato");
            System.out.println("5: Ver informações de funcionário");
            System.out.println("6: Sair");
            System.out.println("++++++++++++++++++++++++++++++++++\n");

            option = scanner.nextInt();

            //Código pra chamar os métodos presentes nas classes (métodos ainda por fazer)
            switch (option) {
                case 1:
                    System.out.println("Escreva o nome e a mesa a ocupar:\n");
                    String nome = scanner.nextLine();
                    int numeroMesa = scanner.nextInt();
                    Cliente cliente = new Cliente(nome, numeroMesa);
                    break;

                case 2:
                    System.out.println("Selecione dois pratos usando o ID do cardápio (Digite 0000 para pular um prato), e depois selecione a mesa\n");
                    int idPrato1 = scanner.nextInt();
                    int idPrato2 = scanner.nextInt();
                    int mesa = scanner.nextInt();
                    Pedido pedido = new Pedido(idPrato1, idPrato2, mesa);
                    break;

                case 3:
                    //Este método deve checar e executar o pagamento, e gerar um arquivo de recibo usando o filemanager
                    /*System.out.println("Escreva o ID do pedido a ser pago e o valor coletado: \n");
                    int idPedidoPagto = scanner.nextInt();
                    Double valor = scanner.nextDouble();
                    Pedido.Pagar(idPedidoPagto, valor);*/
                    break;

                case 4:
                    //Esse método deve ser usado em conjunto com o filemanager, para acessar um arquivo de lista de pratos e adicionar uma linha nova
                    /*System.out.println("Digite o id, nome e preço do novo prato: ");
                    int idPrato = scanner.nextInt();
                    String nomePrato = scanner.nextLine();
                    Double precoPrato = scanner.nextDouble();
                    Cardapio prato = new Cardapio();*/
                    break;

                case 5 :
                
                    System.out.println("digite o Id do Funcionário para mais informações");
                    int idFuncionario = scanner.nextInt();
                    Funcionario.lerInformacoes(idFuncionario);
                    break;

                case 6 :
                    System.out.println("Saindo do programa...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Operação invalida!");
                    break;
            }        
        }
    }
}