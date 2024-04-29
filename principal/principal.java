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
                System.out.println("Escreva a mesa a ocupar:\n");
                int numeroMesa = scanner.nextInt();
                Cliente cliente = new Cliente(numeroMesa);
                break;

            case "B":
                System.out.println("Escreva o Id do prato seguido pela quantidade (pode selecionar mais 3 vezes):\n");
                //a fazer
                Pedido.pedido();
                break;

            case "C":
                System.out.println("Escreva o Id do pedido a ser entregue:\n");
                int idPedido = scanner.nextInt();
                //talvez precise de código pra reconhecer a instância correta a partir do idPedido, terminar o ArrayList ou usar outro método de organização
                Pedido.entregar(idPedido);
                break;

            case "D":
                System.out.println("Escreva a mesa que realizará o pagamento e o valor coletado: \n");
                int idPedidoPagto = scanner.nextInt();
                Double valor = scanner.nextDouble();
                //esse método existe na classe pedido, mas não funciona pois tem que fazer uma referência estática a um campo não estático, precisamos implementar uma database de pedidos e conectar
                Pedido.pagar(idPedidoPagto, valor);
                break;

            case "E":
                System.out.println("Digite o id, nome e preço do novo prato: ");
                int idPrato = scanner.nextInt();
                String nomePrato = scanner.nextLine();
                Double precoPrato = scanner.nextDouble();
                //não sei como isso vai ficar com a lista, mas esse código é só pra ter uma ideia
                Cardapio prato = new Cardapio();
                break;

            case "F":
                System.out.println("Digite o Id, Nome, CPF, Salário e Posição do funcionário");
                int idFuncionario = scanner.nextInt();
                String nome = scanner.nextLine();
                String documento = scanner.nextLine();
                Double salario = scanner.nextDouble();
                String posicao = scanner.nextLine();
                Funcionario funcionario = new Funcionario(idFuncionario, nome, documento, salario, posicao);
                break;

            case "G":
                System.out.println("Digite o id do funcionário para começar/terminar o turno: ");
                int idFuncionarioPonto = scanner.nextInt();
                // mesmo problema do caso D e E, precisamos de alguma instância de funcionário mas não podemos colocar diretamente no código, acho que precisaremos de uma database mesmo
                Funcionario.baterPonto(idFuncionarioPonto);
                break;

            case "H":
                System.out.println("Digite o id do Funcionário para realizar o pagamento: ");
                int idFuncionarioPagar = scanner.nextInt();
                //também necessita database
                Funcionario.pagarSalario(idFuncionarioPagar);
                break;

            case "I":
            System.out.println("Digite o id do Funcionário e o novo valor do salário: ");
            int idFuncionarioAumento = scanner.nextInt();
            Double valorAumento = scanner.nextDouble();
            //também necessita database
            Funcionario.aumento(idFuncionarioAumento, valorAumento);
                break;

            case "J":
                System.out.println("Digite o id do Funcionário para realizar a demissão: ");
                int idFuncionarioDemissao = scanner.nextInt();
                //também necessita database
                Funcionario.Demitir(idFuncionarioDemissao);
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
