package br.com.store.magic.model;

import org.hibernate.annotations.Type;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Audited
@AuditTable(schema = "aud_base", value = "card")
@EntityListeners(AuditingEntityListener.class)
@Table(schema = "base", name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "i_card")
    private Long iCard;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Size(max = 255, message = "O nome da carta não deve ultrapassar 255 caracteres!")
    @Column(name = "nome_card")
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
