package br.com.gerenciador.model;

public enum Responsavel {

    PO("PO"),
    CTO("CTO"),
    DEV("DEV"),
    QA("QA");

    private final String descricao;

    Responsavel(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Responsavel porNome(String elemento) {
        for (Responsavel resp : Responsavel.values()) {
            if (resp.descricao.equalsIgnoreCase(elemento)) {
                return resp;
            }
        }
        return null;
    }
}
