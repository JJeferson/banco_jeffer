package com.banco_jeffer.domain.enums;

public enum TipoConta {
    C("A", "Conta Corrente"),
    P("P", "Conta Poupança"),
    I("I", "Conta de Investimento");

    private String chave;

    private String descricao;

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    TipoConta(String chave, String descricao){
        this.chave = chave;
        this.descricao = descricao;
    }

}
