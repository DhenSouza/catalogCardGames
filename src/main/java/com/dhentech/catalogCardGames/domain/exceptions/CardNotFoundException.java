package com.dhentech.catalogCardGames.domain.exceptions;

public class CardNotFoundException extends EntityNotFoundException {
    private static final long serialVersionUID = 1L;

    public CardNotFoundException(String msg){
        super(msg);
    }

    public CardNotFoundException(Long cardId){
        this(String.format("There is no Card registration with the code %d", cardId));
    }
}
