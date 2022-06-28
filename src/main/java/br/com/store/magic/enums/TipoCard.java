package br.com.store.magic.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoCard {
    T("T", "Terreno"),
    C("C", "Criatura"),
    A("A", "Artefato"),
    AC("AC", "Artefato-Criatura"),
    TO("TO", "Token");

    private final String chave;
    private final String descricao;

    TipoCard(String chave, String descricao) {
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
            case T:
            case A:
            case C:
            case AC:
            case TO:
                return getChave();
        }
        return "Valor Inválido";
    }
}
