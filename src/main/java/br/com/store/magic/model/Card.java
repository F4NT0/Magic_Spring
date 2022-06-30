package br.com.store.magic.model;

import br.com.store.magic.DTO.CardDTO;
import br.com.store.magic.enums.CorCard;
import br.com.store.magic.enums.TipoCard;
import org.hibernate.annotations.Type;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.util.List;
import java.util.stream.Collectors;

@Entity
//@Audited
//@AuditTable(schema = "aud_produtos", value = "cards")
//@EntityListeners(AuditingEntityListener.class)
//@Table(schema = "produtos", name = "cards")
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

    @Column(name = "flag_ativo", columnDefinition = "boolean default true")
    private Boolean flagAtivo;

    public Card() {}

    public Card(CardDTO cardDTO) {
        this.nomeCard = cardDTO.getNomeCard();
        this.tipoCard = cardDTO.getTipoCard();
        this.corCard = cardDTO.getCorCard();
        this.flagAtivo = cardDTO.getFlagAtivo();
    }

    /**
     * Desconverte os objetos DTO dos cards vindo da requisição POST
     * @param cardDTOs
     * @return List<Card>
     */
    public static List<Card> desconverterList(List<CardDTO> cardDTOs) {
        return cardDTOs.stream().map(Card::new).collect(Collectors.toList());
    }

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

    public Boolean getFlagAtivo() {
        return flagAtivo;
    }

    public void setFlagAtivo(Boolean flagAtivo) {
        this.flagAtivo = flagAtivo;
    }
}
