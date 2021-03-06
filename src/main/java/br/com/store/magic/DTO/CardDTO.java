package br.com.store.magic.DTO;

import br.com.store.magic.enums.CorCard;
import br.com.store.magic.enums.TipoCard;
import br.com.store.magic.model.Card;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
import java.util.stream.Collectors;


public class CardDTO {

    @ApiModelProperty(position = 1, notes = "Identificação única do aluno")
    private Long iCard;

    @ApiModelProperty(position = 2, notes = "Nome do card")
    private String nomeCard;

    @ApiModelProperty(position = 3, notes = "Tipo do card")
    private TipoCard tipoCard;

    @ApiModelProperty(position = 4, notes = "Cores do card")
    private CorCard corCard;

    @ApiModelProperty(position = 5, notes = "Flag mostrando se o card está ativo para venda")
    private Boolean flagAtivo;

    public CardDTO() {}

    public CardDTO(Card card) {
        this.iCard = card.getiCard();
        this.nomeCard = card.getNomeCard();
        this.tipoCard = card.getTipoCard();
        this.corCard = card.getCorCard();
        this.flagAtivo = card.getFlagAtivo();
    }

    /**
     * Conversor do tipo Card do model para o tipo CardDTO utilizando o stream()
     * @param cards
     * @return List
     */
    public static List<CardDTO> converterList(List<Card> cards) {
        return cards.stream().map(CardDTO::new).collect(Collectors.toList());
    }

    /**
     * Conversos do tipo card para o tipo CardDTO
     * @param card
     * @return Card
     */
    public static CardDTO converterId(Card card) {
        return new CardDTO(card);
    }

    public Long getiCard() {
        return iCard;
    }

    public String getNomeCard() {
        return nomeCard;
    }

    public TipoCard getTipoCard() {
        return tipoCard;
    }

    public CorCard getCorCard() {
        return corCard;
    }

    public void setiCard(Long iCard) {
        this.iCard = iCard;
    }

    public void setNomeCard(String nomeCard) {
        this.nomeCard = nomeCard;
    }

    public void setTipoCard(TipoCard tipoCard) {
        this.tipoCard = tipoCard;
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
