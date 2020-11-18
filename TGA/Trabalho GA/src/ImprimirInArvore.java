class ImprimirInArvore {

    void imprimirPreOrdem(final Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.getValor() + "  ");
            if (nodo.getNodoEsquerda() != null) {
                imprimirPreOrdem(nodo.getNodoEsquerda());
            }

            if (nodo.getNodoDireita() != null) {
                imprimirPreOrdem(nodo.getNodoDireita());
            }
        }
    }

    void imprimirInOrdem(final Nodo nodo) {
            if (nodo != null) {
                if (nodo.getNodoEsquerda() != null) {
                    imprimirInOrdem(nodo.getNodoEsquerda());
                }

                System.out.print(nodo.getValor() + "  ");
                if (nodo.getNodoDireita() != null) {
                    imprimirInOrdem(nodo.getNodoDireita());
                }
            }
        }

        void imprimirPosOrdem(final Nodo nodo) {
            if (nodo != null) {
                if (nodo.getNodoEsquerda() != null) {
                    imprimirPosOrdem(nodo.getNodoEsquerda());
                }

                if (nodo.getNodoDireita() != null) {
                    imprimirPosOrdem(nodo.getNodoDireita());
                }

                System.out.print(nodo.getValor() + "  ");
            }
    }
}
