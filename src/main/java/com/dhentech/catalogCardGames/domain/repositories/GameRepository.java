package com.dhentech.catalogCardGames.domain.repositories;

import com.dhentech.catalogCardGames.domain.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
}
