class ExibirArvore {

    private static final int ZERO = 0;
    private static final int UM = 1;

    String exibir(final Nodo nodo, int level) {

        StringBuilder str = new StringBuilder(toString(nodo) + "\n");

        int i;
        for (i = ZERO; i < level; ++i) {
            str.append("\t");
        }

        if (!nodo.nodoEsquerdaNulo()) {
            str.append("+-ESQ: ").append(exibir(nodo.getNodoEsquerda(), level + UM));
        } else {
            str.append("+-ESQ: NULL");
        }

        str.append("\n");

        for (i = ZERO; i < level; ++i) {
            str.append("\t");
        }

        if (!nodo.nodoDireitaNulo()) {
            str.append("+-DIR: ").append(exibir(nodo.getNodoDireita(), level + UM));
        } else {
            str.append("+-DIR: NULL");
        }

        str.append("\n");
        return str.toString();
    }

    private String toString(final Nodo nodo) {
        return "[" + nodo.getValor() + "] (" + nodo.getBalanceamento() + ")";
    }
}
