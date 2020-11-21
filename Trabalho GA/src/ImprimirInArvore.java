import java.util.ArrayList;

class ImprimirInArvore {

    void imprimirListaPessoas(final ArrayList<Pessoa> pessoas) {
        pessoas.forEach(pessoa -> System.out.println(pessoa.toString()));
    }
}
