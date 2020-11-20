import java.util.Date;

public class Pessoa {
    private int cpf;
    private int rg;
    private String nome;
    private Date dataNascimento;
    private String cidade;

    public Pessoa(int cpf, int rg, String nome, Date dataNascimento, String cidade) {
        this.cpf = cpf;
        this.rg = rg;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cidade = cidade;
    }

    public int getCpf() {
        return cpf;
    }

    public int getRg() {
        return rg;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public String getCidade() {
        return cidade;
    }

    public String toString() {
        String str = "Nome: " + this.nome;
        str += "\nCPF: " + this.cpf;
        str += "\nRG: " + this.rg;
        str += "\nData de Nascimento: " + this.dataNascimento;
        str += "\nCidade: " + this.cidade;

        return str;
    }
}
