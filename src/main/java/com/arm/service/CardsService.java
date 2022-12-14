package com.arm.service;

import java.util.List;

import com.arm.repository.cards.CardsRepository;
import com.arm.tables.Cards;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class CardsService {
    @Autowired
    CardsRepository repo;

    public void save(Cards cards) {
        repo.save(cards);
    }

    public List<Cards> listAll() {
        return (List<Cards>) repo.findAll();
    }

    public Cards get(int idCards) {
        return repo.findById(idCards).get();
    }

    public void delete(int idCards) {
        repo.deleteById(idCards);
    }
    public List<Cards> search(String keyword) {
        return repo.search(keyword);
    }

}