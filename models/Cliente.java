package models;

public class Cliente {
    
    //Coloquei nome para que possamos diferenciar vários clientes quando as mesas se repetirem
    public String nome;
    private int numeroMesa;

    /*Método de criação de classe cliente, não tem nenhum uso real pois os pedidos e pagamentos são feitos com foco no id de pedido, mas seria útil pra uma expansão no código*/
    public Cliente(String nome, int numeroMesa) {
        this.nome = nome;
        this.numeroMesa = numeroMesa;
        System.out.println("Cliente "+this.nome+" registrado(a) na mesa "+this.numeroMesa+"\n");
    }
}