package com.fis.mylittleboard.domain.card.repository;

import static com.fis.mylittleboard.domain.card.entity.QCowork.cowork;

import com.fis.mylittleboard.domain.card.entity.Card;
import com.fis.mylittleboard.domain.card.entity.QCowork;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CardRepositoryImpl implements CardRepository{

	private final CardJpaRepository cardJpaRepository;
	private final JPAQueryFactory jpaQueryFactory;

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

	@Override
	public List<Long> getWorkerIds(Long cardId) {
		return jpaQueryFactory.select(cowork.workerId)
			.from(cowork)
			.where(cowork.cardId.eq(cardId))
			.fetch();


	}
}
