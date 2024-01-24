package com.dhentech.catalogCardGames.domain.services;

import com.dhentech.catalogCardGames.domain.model.Card;
import com.dhentech.catalogCardGames.domain.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    public List<Card> cardList() {
        return cardRepository.findAll();
    }
}
