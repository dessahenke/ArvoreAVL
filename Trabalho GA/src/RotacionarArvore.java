class RotacionarArvore {

    Nodo rotacaoSimplesEsquerda(final Nodo nodo) {
        Nodo filhoDoFilho = null;
        Nodo filhoDireita = nodo.getNodoDireita();
        if (filhoDireita != null && filhoDireita.getNodoEsquerda() != null) {
            filhoDoFilho = filhoDireita.getNodoEsquerda();
        }
        filhoDireita.setNodoEsquerda(nodo);
        nodo.setNodoDireita(filhoDoFilho);
        return filhoDireita;
    }

    Nodo rotacaoSimplesDireita(final Nodo nodo) {
        Nodo filhoDoFilho = null;
        Nodo filhoEsquerda = nodo.getNodoEsquerda();
        if (filhoEsquerda != null && filhoEsquerda.getNodoDireita() != null) {
            filhoDoFilho = filhoEsquerda.getNodoDireita();
        }
        nodo.setNodoEsquerda(filhoDoFilho);
        filhoEsquerda.setNodoDireita(nodo);
        return filhoEsquerda;
    }

    Nodo rotacaoDuplaEsquerda(final Nodo nodo) {
        Nodo filhoDireita = nodo.getNodoDireita();
        Nodo filhoDoFilho = filhoDireita.getNodoEsquerda();
        Nodo noInserido = filhoDoFilho.getNodoDireita();
        filhoDireita.setNodoEsquerda(noInserido);
        filhoDoFilho.setNodoDireita(filhoDireita);
        nodo.setNodoDireita(filhoDoFilho);
        Nodo novoFilhoDireita = nodo.getNodoDireita();
        nodo.setNodoDireita(null);
        novoFilhoDireita.setNodoEsquerda(nodo);
        return novoFilhoDireita;
    }

    Nodo rotacaoDuplaDireita(final Nodo nodo) {
        Nodo filhoEsquerda = nodo.getNodoEsquerda();
        Nodo filhoDoFilho = filhoEsquerda.getNodoDireita();
        Nodo noInserido = filhoDoFilho.getNodoEsquerda();
        filhoEsquerda.setNodoDireita(noInserido);
        filhoDoFilho.setNodoEsquerda(filhoEsquerda);
        nodo.setNodoEsquerda(filhoDoFilho);
        Nodo novoFilhoEsquerda = nodo.getNodoDireita();
        nodo.setNodoEsquerda(null);
        novoFilhoEsquerda.setNodoDireita(nodo);
        return novoFilhoEsquerda;
    }
}
