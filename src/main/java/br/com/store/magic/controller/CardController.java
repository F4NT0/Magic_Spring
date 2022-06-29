package br.com.store.magic.controller;

import br.com.store.magic.DTO.CardDTO;
import br.com.store.magic.model.Card;
import br.com.store.magic.repository.CardRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class CardController {

    private static final String URL_PLURAL = "/cards";
    private static final String URL_SINGULAR = "/card/{id}";

    @Autowired
    private CardRepository cardRepository;

    /**
     * Requisição de busca de Cards cadastrados como Lista
     * @return List
     */
    @GetMapping(value = URL_PLURAL, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Busca em lista de todos os card cadastrados")
    public List<CardDTO> buscaCards() {
        List<Card> cards = cardRepository.findAll();
        return CardDTO.converterList(cards);
    }

    /**
     * Requisição de busca de cards pelo ID
     * @param id
     * @return CardDTO
     */
    @GetMapping(value = URL_SINGULAR, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Busca de um Card pelo seu ID")
    public CardDTO buscaCardPorId(@PathVariable Long id) {
        Card card = cardRepository.findByiCard(id);
        return CardDTO.converterId(card);
    }

    /**
     * Requisição de cadastro de um card novo
     * @param card
     * @return Long
     */
    @PostMapping(value = URL_PLURAL, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Cria um card por requisição")
    public Long cadastraCard(@RequestBody Card card) {
        cardRepository.save(card);
        return card.getiCard();
    }

}
