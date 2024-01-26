package com.dhentech.catalogCardGames.api.controllers;

import com.dhentech.catalogCardGames.domain.model.Game;
import com.dhentech.catalogCardGames.domain.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/Games")
public class GameController {

    @Autowired
    private GameService gameService;
    @GetMapping("/Search/{id}")
    public Game findGameById(@PathVariable Long id){
        return gameService.findByIdGame(id);
    }
}
