package com.fis.mylittleboard.domain.card.repository.cardlabel;

import com.fis.mylittleboard.domain.card.entity.CardLabel;
import com.fis.mylittleboard.domain.card.repository.cardlabel.CardLabelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CardLabelRepositoryImpl implements CardLabelRepository {

	private final CardLabelJpaRepository cardLabelJpaRepository;

	@Override
	public void save(CardLabel cardLabel) {
		cardLabelJpaRepository.save(cardLabel);
	}
}
