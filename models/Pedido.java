package models;

import java.io.IOException;
import file_manager.FileManager;

public class Pedido {
    public int idPedido; // Identificacao do pedido
    public int idPrato1; // Identificacao do primeiro prato do pedido
    public int idPrato2; // Identificacao do segundo prato do pedido
    public Double precoTotal; // Preco total do pedido
    public int mesa; // Numero da mesa do cliente

    /*Construtor de classe, salva o pedido num arquivo txt.
    Número máximo de pratos no pedido é 2, poderiamos fazer mais mas para manter simples deixamos assim.
    Para selecionar somente 1 prato é só digitar um id de prato 0000 em uma das opções(prato vazio de custo zero)*/
    public Pedido(int idPrato1, int idPrato2, int mesa) throws NumberFormatException, IOException{
        //Função para encontrar o próximo id baseado no último id disponível
        this.idPedido = FileManager.proxId();
        this.idPrato1 = idPrato1;
        this.idPrato2 = idPrato2;
        //Função para somar o preço dos dois pratos
        this.precoTotal = FileManager.calculoPreco(idPrato1, idPrato2);
        this.mesa = mesa;
        //Função de salvamento de pedido em pedidos.txt
        FileManager.salvarPedido(this.idPedido, this.idPrato1, this.idPrato2,this.precoTotal, this.mesa);
    }

    //Função de pagamento
    public static void Pagar(int idPedidoPagto, Double valor) throws NumberFormatException, IOException{
        FileManager.checarPagto(idPedidoPagto, valor);
    }
}