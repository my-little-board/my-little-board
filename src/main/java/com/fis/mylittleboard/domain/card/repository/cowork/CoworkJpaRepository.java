package com.fis.mylittleboard.domain.card.repository.cowork;

import com.fis.mylittleboard.domain.card.entity.CardMember;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoworkJpaRepository extends JpaRepository<CardMember, Long> {

	List<CardMember> findByCardId(Long cardId);
}
