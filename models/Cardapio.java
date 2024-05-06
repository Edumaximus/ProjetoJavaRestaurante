package models;
import java.util.ArrayList;
import java.util.List;

public class Cardapio{
    public int idPrato; // identificacao do prato
    public String prato; // Nome do prato
    public Double preco; // Preco do prato


    public Cardapio(int idPrato, String prato, Double preco){
    this.idPrato = idPrato;
    this.prato = prato;
    this.preco = preco;
    }

    public int getIdPrato(){
        return this.idPrato;
    }
    public String getPrato(){
    return this.prato;
    }
    public Double getPreco(){
    return this.preco;
    }
}
