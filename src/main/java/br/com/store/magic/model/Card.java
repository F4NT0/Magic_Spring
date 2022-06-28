package br.com.store.magic.model;

import br.com.store.magic.enums.CorCard;
import br.com.store.magic.enums.TipoCard;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "i_card")
    private Long iCard;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "nome_card")
    private String nomeCard;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_card")
    private TipoCard tipoCard;

    @Enumerated(EnumType.STRING)
    @Column(name = "cor_card")
    private CorCard corCard;


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

    public CorCard getCorCard() {
        return corCard;
    }

    public void setCorCard(CorCard corCard) {
        this.corCard = corCard;
    }
}
