package com.fis.mylittleboard.domain.card.repository;

import com.fis.mylittleboard.domain.card.entity.Cowork;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoworkJpaRepository extends JpaRepository<Cowork, Long> {

	List<Cowork> findByCardId(Long cardId);
}
