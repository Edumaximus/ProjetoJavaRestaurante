package models;


public class Cliente {
    
    //coloquei nome para que possamos diferenciar vários clientes quando as mesas se repetirem
    public String nome;
    private int numeroMesa;

    public Cliente(String nome, int numeroMesa) {
        this.nome = nome;
        this.numeroMesa = numeroMesa;
        System.out.println("Cliente "+this.nome+" registrado(a) na mesa "+this.numeroMesa+"\n");
    }
}
