package com.dhentech.catalogCardGames.api.controllers;

import com.dhentech.catalogCardGames.domain.exceptions.BusinessException;
import com.dhentech.catalogCardGames.domain.exceptions.CardNotFoundException;
import com.dhentech.catalogCardGames.domain.model.Card;
import com.dhentech.catalogCardGames.domain.services.CardService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/Cards")
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping("/list")
    public ResponseEntity<List<Card>> listCards(){
        return ResponseEntity.ok(cardService.cardList());
    }

    @GetMapping("/Search/{id}")
    public Card findCardById(@PathVariable Long id){
        return cardService.findByIdCard(id);
    }

    public ResponseEntity<Card> addACard(Card card){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(cardService.saveACard(card));
        } catch (CardNotFoundException e){
            throw new BusinessException(e.getMessage(), e);
        }
    }
}
