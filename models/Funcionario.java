package models;

import java.io.IOException;

import file_manager.FileManager;

public class Funcionario {
    
    public int idFuncionario; //Indentificacao do funcionario.
    public String nome; // Nome do funcionario.
    public String posicao; // Posicao ou cargo do funcionario.
    public String documento; // Documento do funcionario.
    public Double salario; // Salario do funcionario.
    public Boolean emServico; // Se está em seu turno ou não.
    
// Construtor da classe.
    public Funcionario(int idFuncionario, String nome, String documento, Double salario, String posicao) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.documento = documento;
        this.salario = salario;
        this.posicao = posicao;
    }

  //Metodos para acessar os atributos.  
    public int getIdFuncionario() {
        return idFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public double getSalario() {
        return salario;
    }

    public String getPosicao() {
        return posicao;
    }

    public static void lerInformacoes(int idFuncionario) throws IOException{
        FileManager.leituraFuncionarios(idFuncionario);
    }
}