package com.fis.mylittleboard.domain.card.repository;

import com.fis.mylittleboard.domain.card.entity.Card;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CardRepositoryImpl implements CardRepository{

	private final CardJpaRepository cardJpaRepository;

	@Override
	public Card save(Card card) {
		cardJpaRepository.save(card);
		return card;
	}

	@Override
	public Optional<Card> findById(Long cardId) {
		return cardJpaRepository.findById(cardId);
	}

	@Override
	public void delete(Card card) {
		cardJpaRepository.delete(card);
	}
}
