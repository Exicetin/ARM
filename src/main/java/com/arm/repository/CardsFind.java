package com.arm.repository;
import com.arm.tables.Cards;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;

public interface CardsFind extends CrudRepository<com.arm.tables.Cards,Integer> {
    /* интерфейс для взаимодействия с карточками
    *
    *
    *  List<Card> bauers = repository.findByLinks("Bauer");
        System.out.println("Cards found with findByLinks('Bauer'):");
        System.out.println("--------------------------------------------");
        for (Cards bauer : bauers) {
            System.out.println(bauer);
        }
        * Пример кода для поиска по полю
        *
        *
        *
        * Iterable<Cards> cards = repository.findAll(); //== select * from Cards
        *
        *
        * CardRepository repository = context.getBean(CustomerRepository.class);
        repository.save(new Customer("Jack", "Bauer"));
        * */
    List<com.arm.tables.Cards> findByNumberCard(String  numberCard);
    List<com.arm.tables.Cards> findByNumberLetter(int numberLetter);
    List<com.arm.tables.Cards> findByDateCorrect(Date dateCorrect);
    List<com.arm.tables.Cards> findByDateCreate(Date dateCreate);
    List<com.arm.tables.Cards> findBySendLetter(Date sendLetter);
    List<com.arm.tables.Cards> findByLinks(String links);

}