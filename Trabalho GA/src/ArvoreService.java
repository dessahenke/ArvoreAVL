import java.util.ArrayList;
import java.util.Date;

class ArvoreService {

    private static final int ZERO = 0;
    private ArvoreAVL arvoreAVL = new ArvoreAVL();

    void preInserir(final Pessoa pessoa) {
        arvoreAVL.inserir(pessoa);
        arvoreAVL.calcularBalanceamento();
        arvoreAVL.verificaBalanceamento();
        arvoreAVL.calcularBalanceamento();
        System.out.println(arvoreAVL.exibirArvore(ZERO));
    }

    void preBuscarCPF(int cpf) {
        Pessoa pessoa = arvoreAVL.getPessoa(cpf);
        if (pessoa != null) {
            System.out.println(pessoa.toString());
        } else {
            System.out.println("Não foi possível encontrar a pessoa com CPF " + cpf);
        }
    }

    void preBuscaDataNascimento(Date initialDate, Date finalDate) {
        ArrayList<Pessoa> pessoas = arvoreAVL.buscaPorNascimento(initialDate, finalDate);
        arvoreAVL.imprimirPessoas(pessoas);
    }

    void preBuscaNome(String nome) {
        ArrayList<Pessoa> pessoas = arvoreAVL.buscaPorNome(nome);
        arvoreAVL.imprimirPessoas(pessoas);
    }
}