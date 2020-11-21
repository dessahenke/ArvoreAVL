import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

class ArvoreService {

    private static final int ZERO = 0;
    private ArvoreAVL arvoreAVL = new ArvoreAVL();

    Date transformToDate(String stringDate) {
        Date dt = new Date();

        try {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            dt = df.parse(stringDate);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return dt;
    }

    void inserirPessoa(final String[] infos) {
        Long cpf = Long.parseLong(infos[0]);
        Long rg = Long.parseLong(infos[1]);
        String nome = infos[2].replaceAll("\"","").replaceAll(","," ");
        Date dataNascimento = transformToDate(infos[3]);
        String cidade = infos[4];

        Pessoa pessoa = new Pessoa(cpf, rg, nome, dataNascimento, cidade);
        preInserir(pessoa);
    }

    void preInserir(final Pessoa pessoa) {
        arvoreAVL.inserir(pessoa);
        arvoreAVL.calcularBalanceamento();
        arvoreAVL.verificaBalanceamento();
        arvoreAVL.calcularBalanceamento();
        System.out.println(arvoreAVL.exibirArvore(ZERO));
    }

    void preBuscarCPF(String cpf) {
        Long cpfLong = Long.parseLong(cpf);
        Pessoa pessoa = arvoreAVL.getPessoa(cpfLong);
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