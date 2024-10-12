package br.com.gerenciador.model;

public enum Prioridade {

    ALTA("ALTA"),
    MEDIA("MEDIA"),
    BAIXA("BAIXA");

    private final String descricao;

    Prioridade(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
