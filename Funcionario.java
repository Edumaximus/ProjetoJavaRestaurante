public class Funcionario {
    
    public int idFuncionario; //Indentificacao do funcionario.
    public String nome; // Nome do funcionario.
    public String posicao; // Numero do documento do funcionario.
    public String documento; // Salario do funcionario.
    public Double salario; // Posicao ou cargo do funncionario.
    
// Construtor da calsse.
    public Funcionario(int idFuncionario, String nome, String documento, double salario, String posicao) {
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
    
}



    
}
