import java.util.ArrayList;

class ImprimirInArvore {

    void imprimirListaPessoas(final ArrayList<Pessoa> pessoas) {
        pessoas.stream().forEach(pessoa -> System.out.println(pessoa.toString()));
    }

//    void imprimirInOrdem(final Nodo nodo) {
//        if (nodo != null) {
//            if (nodo.getNodoEsquerda() != null) {
//                imprimirInOrdem(nodo.getNodoEsquerda());
//            }
//
//            System.out.print(nodo.getValor() + "  ");
//            if (nodo.getNodoDireita() != null) {
//                imprimirInOrdem(nodo.getNodoDireita());
//            }
//        }
//    }
//
//    void imprimirPosOrdem(final Nodo nodo) {
//        if (nodo != null) {
//            if (nodo.getNodoEsquerda() != null) {
//                imprimirPosOrdem(nodo.getNodoEsquerda());
//            }
//
//            if (nodo.getNodoDireita() != null) {
//                imprimirPosOrdem(nodo.getNodoDireita());
//            }
//
//            System.out.print(nodo.getValor() + "  ");
//        }
//    }
}
