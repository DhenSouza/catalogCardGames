package com.dhentech.catalogCardGames.api.controllers;

import com.dhentech.catalogCardGames.domain.model.Card;
import com.dhentech.catalogCardGames.domain.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
}
