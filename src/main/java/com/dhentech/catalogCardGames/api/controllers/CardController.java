package com.dhentech.catalogCardGames.api.controllers;

import com.dhentech.catalogCardGames.domain.exceptions.BusinessException;
import com.dhentech.catalogCardGames.domain.exceptions.CardNotFoundException;
import com.dhentech.catalogCardGames.domain.exceptions.EntityInUseException;
import com.dhentech.catalogCardGames.domain.model.Card;
import com.dhentech.catalogCardGames.domain.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping
    public ResponseEntity<Card> addACard(@RequestBody Card card){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(cardService.saveACard(card));
        } catch (CardNotFoundException e){
            throw new BusinessException(e.getMessage(), e);
        }
    }

    @PutMapping("{id}")
    public Card alterACard(@RequestBody Card card, @PathVariable Long id){
        try {
            return cardService.alterACard(card, id);
        } catch (CardNotFoundException e){
            throw new BusinessException(e.getMessage(), e);
        }
    }
    @DeleteMapping("{id}")
    public void deleteACard(@PathVariable Long id){
        try{
            cardService.deleteACard(id);
        } catch (EntityInUseException e){
            throw new BusinessException(e.getMessage(), e);
        }
    }
}
