package br.com.store.magic.DTO;

import br.com.digifred.global.Utils.DeserializadorJson;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.annotations.ApiModelProperty;

@JsonDeserialize(using = DeserializadorJson.class)
public class CardDTO {

    @ApiModelProperty(position = 1, notes = "Identificação única do aluno")
    private Long iCard;

    @ApiModelProperty(position = 2, notes = "Nome do card")
    private String nomeCard;

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
}
