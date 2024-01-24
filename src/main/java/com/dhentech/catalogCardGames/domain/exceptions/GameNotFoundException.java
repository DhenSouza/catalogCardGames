package com.dhentech.catalogCardGames.domain.exceptions;

public class GameNotFoundException extends EntityNotFoundException {
    private static final long serialVersionUID = 1L;

    public GameNotFoundException(String msg){
        super(msg);
    }

    public GameNotFoundException(Long cardId){
        this(String.format("There is no Game registration with the code %d", cardId));
    }
}
