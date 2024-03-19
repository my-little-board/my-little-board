package com.fis.mylittleboard.domain.card.repository;

import com.fis.mylittleboard.domain.card.entity.Card;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CardRepositoryImpl implements CardRepository{

	private final CardJpaRepository cardJpaRepository;

	@Override
	public Card save(Card card) {
		return cardJpaRepository.save(card);
	}
}
