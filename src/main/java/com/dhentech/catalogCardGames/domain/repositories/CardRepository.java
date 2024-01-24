package com.dhentech.catalogCardGames.domain.repositories;

import com.dhentech.catalogCardGames.domain.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
}
