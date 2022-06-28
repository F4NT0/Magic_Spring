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

    public CardDTO(Card card) {
        this.iCard = card.getiCard();
        this.nomeCard = card.getNomeCard();
        this.tipoCard = card.getTipoCard();
        this.corCard = card.getCorCard();
    }

    /**
     * Conversor do tipo Card do model para o tipo CardDTO utilizando o stream()
     * @param cards
     * @return
     */
    public static List<CardDTO> converter(List<Card> cards) {
        return cards.stream().map(CardDTO::new).collect(Collectors.toList());
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
}
