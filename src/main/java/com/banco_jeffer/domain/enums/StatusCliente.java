package com.banco_jeffer.domain.enums;

public enum StatusCliente {
    A("A", "Ativo"),
    I("I", "Inativo");

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

    StatusCliente(String chave, String descricao){
        this.chave = chave;
        this.descricao = descricao;
    }


}
