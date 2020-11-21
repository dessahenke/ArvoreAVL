import java.util.ArrayList;
import java.util.Date;

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

    void imprimirPessoas(ArrayList<Pessoa> pessoas) {
        new ImprimirInArvore().imprimirListaPessoas(pessoas);
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

    ArrayList<Pessoa> buscaPorNome(String nome) {
        return buscaPorNome(nome, raiz);
    }

    private ArrayList<Pessoa> buscaPorNome(String nome, final Nodo nodo) {
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        if (nodo != null) {
            Pessoa pessoa = nodo.getPessoa();

            if(pessoa.getNome().startsWith(nome)){
                pessoas.add(pessoa);
            }

            if (nodo.getNodoEsquerda() != null) {
                buscaPorNome(nome, nodo.getNodoEsquerda());
            }

            if (nodo.getNodoDireita() != null) {
                buscaPorNome(nome, nodo.getNodoDireita());
            }
        }

        return pessoas;
    }

    ArrayList<Pessoa> buscaPorNascimento(Date initialDate, Date finalDate) {
        return buscaPorNascimento(initialDate, finalDate, raiz);
    }

    private ArrayList<Pessoa> buscaPorNascimento(Date initialDate, Date finalDate, final Nodo nodo) {
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        if (nodo != null) {
            Pessoa pessoa = nodo.getPessoa();
            boolean isAfterInicialDate = pessoa.getDataNascimento().after(initialDate);
            boolean isBeforeFinalDate = pessoa.getDataNascimento().before(finalDate);

            if(isAfterInicialDate && isBeforeFinalDate){
                pessoas.add(pessoa);
            }

            if (nodo.getNodoEsquerda() != null) {
                buscaPorNascimento(initialDate, finalDate, nodo.getNodoEsquerda());
            }

            if (nodo.getNodoDireita() != null) {
                buscaPorNascimento(initialDate, finalDate, nodo.getNodoDireita());
            }
        }

        return pessoas;
    }

    Pessoa getPessoa(final Long valor) {
        return getPessoa(valor, raiz);
    }

    private Pessoa getPessoa(final Long cpf, final Nodo nodo) {

        if (nodo == null) {
            return null;
        } else if (nodo.getChave().equals(cpf)) {
            return nodo.getPessoa();
        } else if (cpf < nodo.getChave()) {
            if(nodo.getNodoEsquerda() != null) {
                return getPessoa(cpf, nodo.getNodoEsquerda());
            }
        } else if (cpf > nodo.getChave()) {
            if(nodo.getNodoDireita() != null) {
                return getPessoa(cpf, nodo.getNodoDireita());
            }
        }
        return null;
    }

}
