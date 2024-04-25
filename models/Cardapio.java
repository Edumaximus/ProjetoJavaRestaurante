package models;
import java.util.ArrayList;
import java.util.List;

public class Cardapio{

    public int idPrato; // identificacao do prato
    public String prato; // Nome do prato
    public Double preco; // Preco do prato

    private list<Produto> produtos; // Lista de produtos

    //Construtor da classe
    public Cardapio(){
        this.produtos = new ArrayList<>();
    }

}
