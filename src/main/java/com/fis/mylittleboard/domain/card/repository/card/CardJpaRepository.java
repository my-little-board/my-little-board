package com.fis.mylittleboard.domain.card.repository.card;

import com.fis.mylittleboard.domain.card.entity.Card;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardJpaRepository extends JpaRepository<Card, Long> {

  List<Card> findByProgressId(Long progressId);

  void deleteAllById (Long boardId);
}
