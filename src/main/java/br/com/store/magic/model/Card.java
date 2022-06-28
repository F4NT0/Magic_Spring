package br.com.store.magic.model;

import br.com.store.magic.enums.CorCard;
import br.com.store.magic.enums.TipoCard;

import java.util.List;

public class Card {

    private Long iCard;
    private String nomeCard;
    private TipoCard tipoCard;
    private List<CorCard> coresCard;


    public Long getiCard() {
        return iCard;
    }

    public void setiCard(Long iCard) {
        this.iCard = iCard;
    }

    public String getNomeCard() {
        return nomeCard;
    }

    public void setNomeCard(String nomeCard) {
        this.nomeCard = nomeCard;
    }

    public TipoCard getTipoCard() {
        return tipoCard;
    }

    public void setTipoCard(TipoCard tipoCard) {
        this.tipoCard = tipoCard;
    }

    public List<CorCard> getCoresCard() {
        return coresCard;
    }

    public void setCoresCard(List<CorCard> coresCard) {
        this.coresCard = coresCard;
    }
}
