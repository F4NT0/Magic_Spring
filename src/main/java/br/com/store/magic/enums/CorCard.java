package br.com.store.magic.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CorCard {
    B("B", "Branco"),
    A("A", "Azul"),
    P("P", "Preto"),
    R("R", "Vermelho"),
    G("G", "Verde");

    private final String chave;
    private final String descricao;

    CorCard(String chave, String descricao) {
        this.chave = chave;
        this.descricao = descricao;
    }

    public String getChave() {
        return chave;
    }

    public String getDescricao() {
        return descricao;
    }

    @JsonValue
    public String getValor() {
        switch (this) {
            case A:
            case B:
            case P:
            case G:
            case R:
                return getChave();
        }
        return "Valor Inválido";
    }
}
