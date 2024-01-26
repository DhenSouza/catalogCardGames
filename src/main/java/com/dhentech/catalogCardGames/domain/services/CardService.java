package com.dhentech.catalogCardGames.domain.services;

import com.dhentech.catalogCardGames.domain.exceptions.BusinessException;
import com.dhentech.catalogCardGames.domain.exceptions.CardNotFoundException;
import com.dhentech.catalogCardGames.domain.exceptions.EntityInUseException;
import com.dhentech.catalogCardGames.domain.model.Card;
import com.dhentech.catalogCardGames.domain.model.Game;
import com.dhentech.catalogCardGames.domain.repositories.CardRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private GameService gameService;

    public List<Card> cardList() {
        return cardRepository.findAll();
    }

    public Card findByIdCard(Long id){
        return cardRepository.findById(id).orElseThrow(() -> new CardNotFoundException(id));
    }

    public Card saveACard(Card card) {
        Long idGame = card.getGame().getId();
        Game game = gameService.findByIdGame(idGame);

        card.setGame(game);

        return cardRepository.save(card);
    }


    public Card alterACard(Card card, Long id) {
        Card cardForLogic = this.findByIdCard(id);
        Game gameForLogic = card.getGame();

        if(gameForLogic.getId() != null){
            gameForLogic = this.gameService.findByIdGame(card.getGame().getId());

            if(gameForLogic != null){
                card.setGame(gameForLogic);
            }
        }
        BeanUtils.copyProperties(card, cardForLogic, "id");
        return cardRepository.save(cardForLogic);
    }

    public void deleteACard(Long id) {
        try{
            cardRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new CardNotFoundException(id);
        } catch (DataIntegrityViolationException e){
            throw new EntityInUseException(e.getMessage());
        }
    }
}
