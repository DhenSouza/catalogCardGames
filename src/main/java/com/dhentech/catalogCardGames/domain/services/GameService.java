package com.dhentech.catalogCardGames.domain.services;

import com.dhentech.catalogCardGames.domain.exceptions.GameNotFoundException;
import com.dhentech.catalogCardGames.domain.model.Game;
import com.dhentech.catalogCardGames.domain.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<Game> listGames(){
        return gameRepository.findAll();
    }
    public Game findByIdGame(Long id){
        return gameRepository.findById(id).orElseThrow(() -> new GameNotFoundException(id));
    }
}
