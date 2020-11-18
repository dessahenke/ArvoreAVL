
class ArvoreService {

    private static final int ZERO = 0;
    private ArvoreAVL arvoreAVL = new ArvoreAVL();

    void preInserir(final int valor) {
        arvoreAVL.inserir(valor);
        arvoreAVL.calcularBalanceamento();
        arvoreAVL.verificaBalanceamento();
        arvoreAVL.calcularBalanceamento();
        System.out.println(arvoreAVL.exibirArvore(ZERO));
    }

    void preBuscar(int valorInserido) {
        if (arvoreAVL.busca(valorInserido)) {
            System.out.println("O valor " + valorInserido + " está contido na árvore.");
        } else {
            System.out.println("O valor " + valorInserido + " não foi encontrado na árvore.");
        }
    }

    void preRemover(int valorInserido) {
        arvoreAVL.remover(valorInserido);
        arvoreAVL.calcularBalanceamento();
        arvoreAVL.verificaBalanceamento();
        System.out.println(arvoreAVL.exibirArvore(0));
    }

    void imprimirInOrdem() {
        arvoreAVL.imprimirInOrdem();
    }

    void imprimirPreOrdem() {
        arvoreAVL.imprimirPreOrdem();
    }

    void imprimirPosOrdem() {
        arvoreAVL.imprimirPosOrdem();
    }
}