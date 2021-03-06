package br.com.store.magic.repository;

import br.com.store.magic.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    Card findByiCard(Long id);

    Card findBynomeCard(String nomeCard);
}
