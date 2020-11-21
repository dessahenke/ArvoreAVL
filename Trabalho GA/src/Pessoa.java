import java.util.Date;

public class Pessoa {
    private final Long cpf;
    private final Long rg;
    private final String nome;
    private final Date dataNascimento;
    private final String cidade;

    public Pessoa(Long cpf, Long rg, String nome, Date dataNascimento, String cidade) {
        this.cpf = cpf;
        this.rg = rg;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cidade = cidade;
    }

    public Long getCpf() {
        return cpf;
    }

    public Long getRg() {
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
