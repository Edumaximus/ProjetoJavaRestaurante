package models;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import file_manager.FileManager;

public class Pedido {
    public static volatile int nextId = 0; 
    public int idPedido; // Identificacao do pedido
    public int idPrato1; // Identificacao do primeiro prato do pedido
    public int idPrato2; // Identificacao do segundo prato do pedido
    public Double precoTotal; // Preco total do pedido
    public int mesa; // Numero da mesa do cliente

    public Pedido(int idPrato1, int idPrato2, int mesa) throws NumberFormatException, IOException{
        this.idPedido = FileManager.proxId();
        this.idPrato1 = idPrato1;
        this.idPrato2 = idPrato2;
        this.precoTotal = FileManager.calculoPreco(idPrato1, idPrato2);
        this.mesa = mesa;
        FileManager.salvarPedido(this.idPedido, this.idPrato1, this.idPrato2,this.precoTotal, this.mesa);
    }

    public static void Pagar(int idPedidoPagto, Double valor) throws NumberFormatException, IOException{
        FileManager.checarPagto(idPedidoPagto, valor);
    }
}
