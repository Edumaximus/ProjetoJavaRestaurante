package models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import file_manager.FileManager;

public class Cardapio{
    public int idPrato; // identificacao do prato
    public String prato; // Nome do prato
    public Double preco; // Preco do prato

    //Construtor da classe
    public Cardapio(int idPrato, String prato, Double preco){
    this.idPrato = idPrato;
    this.prato = prato;
    this.preco = preco;
    }

    //Método de remoção de pratos do cardápio
    public static void remover(int idRemocao) throws IOException{
        FileManager.deleteMenuItem(idRemocao);
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