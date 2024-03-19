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

		List<Long> workers = requestDto.getWorkers();

		Card savedCard = cardRepository.save(card);

		workers.stream()
			.map(l -> new Cowork(savedCard.getId(), l))
			.forEach(coworkRepository::save);

	}

	@Override
	public void updateCard(Long cardId, CardRequestDto cardRequestDto) {

		Card card = cardRepository.findById(cardId)
			.orElseThrow(() -> new IllegalArgumentException("카드가 존재하지 않습니다."));

		card.update(cardRequestDto);
	}

	@Override
	public void deleteCard(Long cardId) {

		Card card = cardRepository.findById(cardId)
			.orElseThrow(() -> new IllegalArgumentException("카드가 존재하지 않습니다."));

		List<Cowork> works = coworkRepository.findByCardId(cardId);
		works.forEach(coworkRepository::delete);

		cardRepository.delete(card);
	}
}
