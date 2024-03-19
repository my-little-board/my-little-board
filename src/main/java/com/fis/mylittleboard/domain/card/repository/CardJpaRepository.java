package com.fis.mylittleboard.domain.card.repository;

import com.fis.mylittleboard.domain.card.entity.Card;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardJpaRepository extends JpaRepository<Card, Long> {

}
