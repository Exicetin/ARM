package com.arm.service;

import com.arm.repository.CardService;
import com.arm.tables.Cards;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Repository
    @Service("jpaContactService")
    @Transactional
    public class CardServiceImpl implements CardService {

        @PersistenceContext
        private EntityManager em;



        public Cards save(Cards cards) {
            if (cards.getIdCards() == 0) {
                em.persist(cards);
            } else {
                em.merge(cards);
            }
            System.out.println("Contact saved with id: " + cards.getIdCards());
            return cards;
        }

    @Override
    public void delete(Cards cards) {
        Cards mergedCards = em.merge(cards);
        em.remove(mergedCards);
        System.out.println("Contact with id: " + mergedCards.getIdCards() + " deleted successfully");
    }


    }

