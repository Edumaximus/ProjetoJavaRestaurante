package models;

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

    public void lerInformacoes(int idFuncionario){
        FileManager.leituraFuncionarios(idFuncionario);


    }

    /*public static void baterPonto(int idFuncionario) {
        if (this.emServico = false) {
            this.emServico = true;
            System.out.println("Turno do funcionário " + this.nome + "iniciado");
        }
        else{
            this.emServico = false;
            System.out.println("Turno do funcionário " + this.nome + "encerrado");
        }
    }

    public static void pagarSalario(int idFuncionario) {
        System.out.println("Funcionario " + this.nome + ", Pagamento realizado.");
    }

    public static void aumento(int idFuncionario, Double valorAumento) {
        Double novoSalario = this.salario+valorAumento;
        System.out.println("Funcionario " + this.nome + " aumento realizado, novo salario: " + novoSalario);
    }

    public static void Demitir(int idFuncionario) {
        /*não sei a função para deletar uma instância de classe, colocar aqui eventualmente
        System.out.println("Funcionario "+ this.nome + "demitido.");
    }*/
}