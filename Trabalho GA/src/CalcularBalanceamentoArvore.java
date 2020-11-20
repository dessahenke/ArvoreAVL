class CalcularBalanceamentoArvore {

    private static final int ZERO = 0;
    private static final int VALOR_ARVORE_DESBALANCEADA = 2;
    private static final int UM = 1;

    private int calcularAltura(final Nodo nodo) {

        if (nodo.nodoEsquerdaNulo() && nodo.nodoDireitaNulo()) {
            return UM;
        } else if (!nodo.nodoEsquerdaNulo() && nodo.nodoDireitaNulo()) {
            return UM + calcularAltura(nodo.getNodoEsquerda());
        } else {
            return nodo.nodoEsquerdaNulo() && !nodo.nodoDireitaNulo() ?
                    UM + calcularAltura(nodo.getNodoDireita()) :
                    UM + Math.max(calcularAltura(nodo.getNodoEsquerda()), calcularAltura(nodo.getNodoDireita()));
        }
    }

    void calcularBalanceamento(final Nodo nodo) {

        if (nodo.nodoEsquerdaNulo()) {

            if (nodo.nodoDireitaNulo()) {
                nodo.setBalanceamento(ZERO);
            } else {
                nodo.setBalanceamento(ZERO - calcularAltura(nodo.getNodoDireita()));
                calcularBalanceamento(nodo.getNodoDireita());
            }

        } else {

            if (nodo.nodoDireitaNulo()) {
                nodo.setBalanceamento(calcularAltura(nodo.getNodoEsquerda()));
            } else {
                nodo.setBalanceamento(calcularAltura(nodo.getNodoEsquerda()) - calcularAltura(nodo.getNodoDireita()));
                calcularBalanceamento(nodo.getNodoDireita());
            }
            calcularBalanceamento(nodo.getNodoEsquerda());
        }

    }

    Nodo verificaBalanceamento(final Nodo nodo) {

        if (nodo.getBalanceamento() >= VALOR_ARVORE_DESBALANCEADA || nodo.getBalanceamento() <= -VALOR_ARVORE_DESBALANCEADA) {
            if (nodo.getBalanceamento() >= VALOR_ARVORE_DESBALANCEADA) {
                if (nodo.getBalanceamento() * nodo.getNodoDireita().getBalanceamento() > ZERO) {
                    System.out.println("Rotacao Simples Direita");
                    return new RotacionarArvore().rotacaoSimplesDireita(nodo);
                } else {
                    System.out.println("Rotacao Dupla Direita");
                    return new RotacionarArvore().rotacaoDuplaDireita(nodo);
                }
            } else {  // bal <= -2
                if (nodo.getBalanceamento() * nodo.getNodoEsquerda().getBalanceamento() > ZERO) {
                    System.out.println("Rotacao Simples Esquerda");
                    return new RotacionarArvore().rotacaoSimplesEsquerda(nodo);
                } else {
                    System.out.println("Rotacao Dupla Esquerda");
                    return new RotacionarArvore().rotacaoDuplaEsquerda(nodo);
                }
            }
        }

        calcularBalanceamento(nodo);

        if (nodo.getNodoEsquerda() != null) nodo.setNodoEsquerda(verificaBalanceamento(nodo.getNodoEsquerda()));
        if (nodo.getNodoDireita() != null) nodo.setNodoDireita(verificaBalanceamento(nodo.getNodoDireita()));
        return nodo;
    }

}
