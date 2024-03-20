package com.fis.mylittleboard.domain.card.repository.card;

import com.fis.mylittleboard.domain.card.entity.Card;
import java.util.List;
import java.util.Optional;


public interface CardRepository {

	Card save(Card card);

	Optional<Card> findById(Long cardId);

	void delete(Card card);

	List<Long> getMemberIds(Long cardId);

	List<Long> getLabelIds(Long cardId);

	List<Card> findByProgressId(Long progressId);
}
