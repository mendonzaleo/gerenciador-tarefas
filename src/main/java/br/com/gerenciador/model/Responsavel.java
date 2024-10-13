package br.com.gerenciador.model;

public enum Responsavel {

    PO("PO"),
    CTO("CTO"),
    DEV("DEV"),
    QA("QA");

    private String descricao;

    Responsavel(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
