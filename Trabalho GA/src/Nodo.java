class Nodo {

    private Long chave;
    private Pessoa pessoa;
    private Nodo nodoDireita;
    private Nodo nodoEsquerda;
    private int balanceamento;

    Nodo(Pessoa pessoa) {
        this.setPessoa(pessoa);
        this.setChave(pessoa.getCpf());
    }

    Long getChave() {
        return this.chave;
    }

    void setChave(Long chave) {
        this.chave = chave;
    }

    Pessoa getPessoa() {
        return pessoa;
    }

    void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    Nodo getNodoDireita() {
        return this.nodoDireita;
    }

    void setNodoDireita(Nodo nodoDireita) {
        this.nodoDireita = nodoDireita;
    }

    Nodo getNodoEsquerda() {
        return this.nodoEsquerda;
    }

    void setNodoEsquerda(Nodo nodoEsquerda) {
        this.nodoEsquerda = nodoEsquerda;
    }

    int getBalanceamento() {
        return this.balanceamento;
    }

    void setBalanceamento(int balanceamento) {
        this.balanceamento = balanceamento;
    }

    boolean nodoDireitaNulo() {
        return nodoDireita == null;
    }

    boolean nodoEsquerdaNulo() {
        return nodoEsquerda == null;
    }

}
