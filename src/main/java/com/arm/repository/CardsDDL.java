package com.arm.repository;

import com.arm.tables.Cards;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

public class CardsDDL  {
    @PersistenceContext
    private EntityManager entityManager;
    @Transactional
    public void insertWithQuery(Cards cards) {
        entityManager.createNativeQuery("INSERT INTO AO_CARDS (idCards,idOtv, numberCard, numberLetter, system, dateCorrect,  dateCreate,  sendLetter, links VALUES (?,?,?)")
                .setParameter(1, cards.getIdCards())
                .setParameter(2,cards.getIdOtv())
                .setParameter(3,cards.getNumberCard())
                .setParameter(4,cards.getNumberLetter())
                .setParameter(5,cards.getSystem())
                .setParameter(6, cards.getDateCorrect())
                .setParameter(7, cards.getDateCreate())
                .setParameter(8,cards.getSendLetter())
                .setParameter(9,cards.getLinks())
                .executeUpdate();
    }

//    public Cards saveCustomer(Cards savedCards) {   //Апдейт
//        Cards cards = new Cards();
//                cards.setIdCards(savedCards.getIdCards());
//                cards.setIdOtv(savedCards.getIdOtv());
//                cards.setNumberCard(savedCards.getNumberCard());
//                cards.setNumberLetter(savedCards.getNumberLetter());
//                cards.setSystem(savedCards.getSystem());
//                cards.setDateCorrect(savedCards.getDateCorrect());
//                cards.setDateCreate(savedCards.getDateCreate());
//                cards.setSendLetter(savedCards.getSendLetter());
//                cards.setLinks(savedCards.getLinks());
//
//                return CardService.save(savedCards);
//    }
}
