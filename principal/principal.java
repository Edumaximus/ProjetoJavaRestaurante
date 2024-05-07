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

        //Sistema de repetição do menu principal depois de executar métodos
        int option;
        while (true) {
            System.out.println("++++++++++++++++++++++++++++++++++");
            System.out.println("Sistema de restaurante");
            System.out.println("1: Registrar cliente");
            System.out.println("2: Registrar pedido");
            System.out.println("3: Registrar pagamento");
            System.out.println("4: Registrar prato");
            System.out.println("5: Ver informações de funcionário");
            System.out.println("6: Remover prato do cardápio");
            System.out.println("7: Checar lista de nomes de pratos");
            System.out.println("8: Checar lista de nomes de pratos em ordem alfabética");
            System.out.println("9: Sair");
            System.out.println("++++++++++++++++++++++++++++++++++\n");

            option = scanner.nextInt();

            //Código pra chamar os métodos presentes nas classes
            switch (option) {
                case 1:
                    System.out.println("Escreva o nome e a mesa a ocupar:\n");
                    String nome = scanner.next();
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
                    System.out.println("Escreva o ID do pedido a ser pago e o valor coletado: \n");
                    int idPedidoPagto = scanner.nextInt();
                    Double valor = scanner.nextDouble();
                    Pedido.Pagar(idPedidoPagto, valor);
                    break;

                case 4:
                  Scanner input = new Scanner(System.in);
                    try {
                        System.out.println("Digite o id do novo prato:");
                        int idPrato = Integer.parseInt(input.nextLine()); // Lê a linha inteira e converte para int

                        System.out.println("Digite o nome do novo prato:");
                        String nomePrato = input.nextLine(); // Lê a linha inteira

                        System.out.println("Digite o preço do novo prato:");
                        double precoPrato = Double.parseDouble(input.nextLine()); // Lê a linha inteira e converte para double

                        // Crie uma representação do novo prato como uma string
                        String novoItem = String.format("%04d,%s,%.2f", idPrato, nomePrato, precoPrato);

                        // Crie uma instância da classe FileManager
                        FileManager fileManager = new FileManager("");

                        // Chame o método adicionarItem para adicionar o novo prato ao cardápio
                        fileManager.adicionarItem(novoItem);
                    } catch (NumberFormatException e) {
                        System.out.println("Formato inválido! Certifique-se de inserir um número válido para o id e o preço.");
                    } finally {
                        input.close();
                    }
                    break;

                case 5 :
                    System.out.println("digite o Id do Funcionário para mais informações");
                    int idFuncionario = scanner.nextInt();
                    Funcionario.lerInformacoes(idFuncionario);
                    break;

                case 6 :
                    System.out.println("Digite o Id do Prato para removê-lo do cardápio");
                    int idRemocao = scanner.nextInt();
                    Cardapio.remover(idRemocao);
                    break;

                case 7 :
                    FileManager.lerPratos();
                    break;

                case 8 :
                    FileManager.lerPratosAlfabetica();
                    break;

                case 9 :
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
