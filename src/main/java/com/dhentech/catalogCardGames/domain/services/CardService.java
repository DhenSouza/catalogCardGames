package com.dhentech.catalogCardGames.domain.services;

import com.dhentech.catalogCardGames.domain.exceptions.CardNotFoundException;
import com.dhentech.catalogCardGames.domain.model.Card;
import com.dhentech.catalogCardGames.domain.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    public static final String CARD_NOT_FOUND = "There is no Card registry with code %d";

    @Autowired
    private CardRepository cardRepository;

    public List<Card> cardList() {
        return cardRepository.findAll();
    }

    public Card findByIdCard(Long id){
        return cardRepository.findById(id).orElseThrow(() -> new CardNotFoundException(id));
    }

    public Card saveACard(Card card) {
        return card;
    }
}
