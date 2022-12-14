package com.arm.repository.cards;
import com.arm.tables.Cards;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CardsRepository extends CrudRepository<com.arm.tables.Cards,Integer> {


    @Query(value = "SELECT c FROM AO_Cards c WHERE c.numberCard LIKE '%' || :keyword || '%'"//глянь этот запрос чет я не понимаю ошибки
            + " OR c.idCards LIKE '%' || :keyword || '%'"
            + " OR c.idOtv LIKE '%' || :keyword || '%'"
            + " OR c.links LIKE '%' || :keyword || '%'"
            + " OR c.numberLetter LIKE '%' || :keyword || '%'"
            + " OR c.system LIKE '%' || :keyword || '%'"
            + " OR c.dateCorrect LIKE '%' || :keyword || '%'"
            + " OR c.dateCreate LIKE '%' || :keyword || '%'"
            + " OR c.sendLetter LIKE '%' || :keyword || '%'"
    )
    public List<Cards> search(@Param("keyword") String keyword);
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
//    List<com.arm.tables.Cards> findByIDCard(int  idCards);
//    List<com.arm.tables.Cards> findByNumberCard(String  numberCard);
//    List<com.arm.tables.Cards> findByNumberLetter(int numberLetter);
//    List<com.arm.tables.Cards> findByDateCorrect(Date dateCorrect);
//    List<com.arm.tables.Cards> findByDateCreate(Date dateCreate);
//    List<com.arm.tables.Cards> findBySendLetter(Date sendLetter);
//    List<com.arm.tables.Cards> findByLinks(String links);

}