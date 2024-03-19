package com.fis.mylittleboard.domain.card.service;

import com.fis.mylittleboard.domain.card.dto.CardRequestDto;
import com.fis.mylittleboard.domain.card.dto.CoworkRequestDto;
import com.fis.mylittleboard.domain.card.entity.Card;
import com.fis.mylittleboard.domain.card.entity.Cowork;
import com.fis.mylittleboard.domain.card.repository.CardRepository;
import com.fis.mylittleboard.domain.card.repository.CoworkRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService{

	private final CardRepository cardRepository;
	private final CoworkRepository coworkRepository;

	@Override
	public void createCard(CardRequestDto requestDto) {
		Card card = new Card(requestDto);
		cardRepository.save(card);
	}

	@Override
	public void addWorkers(Long cardId, CoworkRequestDto coworkRequestDto) {

		List<Long> workers = coworkRequestDto.getWorkers();
		//userId 검증

		Card card = cardRepository.findById(cardId)
			.orElseThrow(() -> new IllegalArgumentException("카드가 존재하지 않습니다."));

		workers.stream()
			.map(l -> new Cowork(card.getId(), l))
			.forEach(coworkRepository::save);

	}
}
