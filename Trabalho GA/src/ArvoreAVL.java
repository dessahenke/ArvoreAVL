
import java.util.Objects;

import static java.util.Optional.ofNullable;

class ArvoreAVL {

    private Nodo raiz;

    void inserir(final Pessoa pessoa) {

        ofNullable(raiz)
                .map(r -> inserir(raiz, pessoa))
                .orElseGet(() -> {
                    raiz = new Nodo(pessoa);
                    return raiz;
                });
    }

    private Nodo inserir(final Nodo nodoAtual, final Pessoa pessoa) {

        if (nodoAtual.getChave() > pessoa.getCpf()) {

            return ofNullable(nodoAtual.getNodoEsquerda())
                    .map(ne -> inserir(ne, pessoa))
                    .orElseGet(() -> {
                        nodoAtual.setNodoEsquerda(new Nodo(pessoa));
                        return nodoAtual.getNodoEsquerda();
                    });

        } else if (nodoAtual.getChave() < pessoa.getCpf()) {
            return ofNullable(nodoAtual.getNodoDireita())
                    .map(nd -> inserir(nd, pessoa))
                    .orElseGet(() -> {
                        nodoAtual.setNodoDireita(new Nodo(pessoa));
                        return nodoAtual.getNodoDireita();
                    });
        }

        System.out.println("Valor já existe na Árvore!");

        return nodoAtual;
    }

    void calcularBalanceamento() {
        new CalcularBalanceamentoArvore().calcularBalanceamento(raiz);
    }

    String exibirArvore(final int nivel) {
        return new ExibirArvore().exibir(raiz, nivel);
    }

    void verificaBalanceamento() {
        raiz = new CalcularBalanceamentoArvore().verificaBalanceamento(raiz);
    }

    void imprimirPreOrdem() {
        new ImprimirInArvore().imprimirPreOrdem(raiz);
    }

    void imprimirInOrdem() {
        new ImprimirInArvore().imprimirInOrdem(raiz);
    }

    void imprimirPosOrdem() {
        new ImprimirInArvore().imprimirPosOrdem(raiz);
    }

    boolean busca(final int valor) {
        return busca(valor, raiz);
    }

    private boolean busca(final int cpf, final Nodo nodo) {

        if (nodo == null) {
            return false;
        } else if (nodo.getChave() == cpf) {
            System.out.println("Nodo consultado: " + nodo.getChave());
            return true;
        } else if (cpf < nodo.getChave()) {
            System.out.println("Nodo consultado: " + nodo.getChave());
            return nodo.getNodoEsquerda() != null && busca(cpf, nodo.getNodoEsquerda());
        } else if (cpf > nodo.getChave()) {
            System.out.println("Nodo consultado: " + nodo.getChave());
            return nodo.getNodoDireita() != null && busca(cpf, nodo.getNodoDireita());
        } else {
            System.out.println("Nodo consultado: " + nodo.getChave());
            return false;
        }
    }

    Nodo remover(final int cpf) {
        return remover(cpf, raiz);
    }

    private Nodo remover(final int elemento, Nodo nodo) {
        if (Objects.nonNull(nodo) && nodo.getChave() == elemento){
            if (nodo.getNodoEsquerda() == null && nodo.getNodoDireita() == null){
                return null;
            }
            else{
                // s� tem filhos � esquerda (acaba sobrando a sub-�rvore da esquerda)
                if (nodo.getNodoEsquerda() != null && nodo.getNodoDireita() == null){
                    return nodo.getNodoEsquerda();
                }
                // s� tem filhos � direita (acaba sobrando a sub-�rvore da direita)
                else if (nodo.getNodoDireita() != null && nodo.getNodoEsquerda() == null){
                    return nodo.getNodoDireita();
                }
                // assumo o maior dentre os filhos
                else{
                    Nodo nodoAuxiliar = nodo.getNodoDireita();
                    while (nodoAuxiliar.getNodoEsquerda() != null){
                        nodoAuxiliar = nodoAuxiliar.getNodoEsquerda();
                    }
                    nodo = nodoAuxiliar;  // troco os valores
                    nodoAuxiliar.setPessoa(elemento);
                    //�rvore da direita recebe a remo��o do elemento (que vai estar numa folha)
                    nodo.setNodoDireita(remover(elemento, nodo.getNodoDireita()));
                }
            }
        }
        else{
            // elemento � menor, ent�o remov�-lo na esquerda
            if (Objects.nonNull(nodo) && elemento < nodo.getValor() ){
                if (nodo.getNodoEsquerda() != null){
                    nodo.setNodoEsquerda(remover(elemento, nodo.getNodoEsquerda()));
                }
            }
            // elemento � maior, ent�o remov�-lo na direita
            else if (Objects.nonNull(nodo) && elemento > nodo.getValor()){
                if (nodo.getNodoDireita() != null){
                    nodo.setNodoDireita(remover(elemento, nodo.getNodoDireita()));
                }
            }
        }
        return nodo;
    }

}
