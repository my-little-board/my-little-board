package com.fis.mylittleboard.domain.card.repository.cardfunction;

import com.fis.mylittleboard.domain.card.entity.CardFunction;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CardFunctionRepositoryImpl implements CardFunctionRepository{

	private final CardFunctionJpaRepository cardFunctionJpaRepository;


	@Override
	public void save(CardFunction cardFunction) {
		cardFunctionJpaRepository.save(cardFunction);
	}

	@Override
	public Optional<CardFunction> findById(Long id) {
		return cardFunctionJpaRepository.findById(id);
	}

	@Override
	public void delete(CardFunction cardFunction) {
		cardFunctionJpaRepository.delete(cardFunction);
	}
}
