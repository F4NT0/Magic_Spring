package br.com.store.magic.controller;

import br.com.store.magic.DTO.CardDTO;
import br.com.store.magic.model.Card;
import br.com.store.magic.repository.CardRepository;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<CardDTO>> buscaCards() {
        List<Card> cards = cardRepository.findAll();
        List<CardDTO> cardDTO = CardDTO.converterList(cards);
        return new ResponseEntity<List<CardDTO>>(cardDTO, HttpStatus.OK);
    }

    /**
     * Requisição de busca de cards pelo ID
     * @param id
     * @return CardDTO
     */
    @GetMapping(value = URL_SINGULAR, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Busca de um Card pelo seu ID")
    public ResponseEntity<CardDTO> buscaCardPorId(@PathVariable Long id) {
        Card card = cardRepository.findByiCard(id);
        CardDTO cardDTO = CardDTO.converterId(card);
        return new ResponseEntity<CardDTO>(cardDTO, HttpStatus.OK);
    }

    /**
     * Requisição para criar novos cards em lista
     * @param cardDTOs
     * @return ResponseEntity<List<CardDTO>>
     */
    @PostMapping(value = URL_PLURAL, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Cria um card por requisição")
    public ResponseEntity<String> cadastraCard(@RequestBody List<CardDTO> cardDTOs) {
        List<Card> cards = Card.desconverterList(cardDTOs);
        for (Card card : cards) {
            Card card1 = cardRepository.findBynomeCard(card.getNomeCard());
            if (card1 != null) {
                String error = "Carta ja existe no sistema";
                return new ResponseEntity<String>(error, HttpStatus.CONFLICT);
            }
        }
        cardRepository.saveAll(cards);
        return new ResponseEntity<String>(cards.toString(),HttpStatus.CREATED);
    }

}
