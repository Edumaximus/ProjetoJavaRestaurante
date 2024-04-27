package models;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    public int idPedido; // Identificacao do pedido
    public int idPrato1; // Identificacao do primeiro prato do pedido
    public int quantPrato1; // Quantidade do primeiro prato do pedido
    public int idPrato2; // Identificacao do segundo prato do pedido
    public int quantPrato2; // Quantidade do segundo prato do pedido
    public int idPrato3; // Identificacao do terceiro prato do pedido
    public int quantPrato3; // Quantidade do terceiro prato do pedido
    public int idPrato4; // Identificacao do quarto prato do pedido
    public int quantPrato4; // Quantidade do quarto prato do pedido
    public Double precoTotal; // Preco total do pedido
    public int mesa; // Numero da mesa do cliente
    public boolean entregue; //Status da entrega do pedido

    private List<Produto> itens; // Lista do pedido

    // Construtor da classe Pedido
    public Pedido(int idPedido) {
        this.idPedido = idPedido; 
        this.itens = new ArrayList<>(); 
    }

    //talvez precise de código pra reconhecer a instância correta a partir do idPedido, terminar o ArrayList ou usar outro método de organização
    public void entregar(int idPedido) {
        boolean entregue = true;
    }

    public void pagar(int idPedidoPagto, Double valor) {

        if (valor == this.precoTotal) {
            System.out.println("Pagamento executado!");
        }
        else{
            System.out.println("Valor do pagamento incorreto");
        }
    }
}
