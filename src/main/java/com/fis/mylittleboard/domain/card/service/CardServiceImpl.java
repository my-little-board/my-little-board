package com.fis.mylittleboard.domain.card.service;

import com.fis.mylittleboard.domain.card.dto.CardRequestDto;
import com.fis.mylittleboard.domain.card.dto.CardResponseDto;
import com.fis.mylittleboard.domain.card.entity.Card;
import com.fis.mylittleboard.domain.card.entity.CardLabel;
import com.fis.mylittleboard.domain.card.entity.Cowork;
import com.fis.mylittleboard.domain.card.repository.card.CardRepository;
import com.fis.mylittleboard.domain.card.repository.cardlabel.CardLabelRepository;
import com.fis.mylittleboard.domain.card.repository.cowork.CoworkRepository;
import com.fis.mylittleboard.domain.label.repository.LabelRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

	private final CardRepository cardRepository;
	private final CoworkRepository coworkRepository;
	private final LabelRepository labelRepository;
	private final CardLabelRepository cardLabelRepository;

	@Override
	public void createCard(CardRequestDto requestDto) {
		Card card = new Card(requestDto);

		List<Long> workers = requestDto.getMembers();
		List<Long> labels = requestDto.getLabels();

		Card savedCard = cardRepository.save(card);

		if (!workers.isEmpty()) {
			workers.stream()
				.map(l -> new Cowork(savedCard.getId(), l))
				.forEach(coworkRepository::save);
		}

		if (!labels.isEmpty()) {
			labels.stream()
				.map(labelRepository::findById)
				.map(optLabel -> optLabel.orElseThrow(
					() -> new IllegalArgumentException("해당 라벨은 존재하지 않습니다.")))
				.forEach(label -> cardLabelRepository.save(
					new CardLabel(savedCard.getId(), label.getId())));
		}


	}

	@Override
	public void updateCard(Long cardId, CardRequestDto cardRequestDto) {

		Card card = cardRepository.findById(cardId)
			.orElseThrow(() -> new IllegalArgumentException("해당 카드가 존재하지 않습니다."));

		card.update(cardRequestDto);
	}

	@Override
	public void deleteCard(Long cardId) {

		Card card = cardRepository.findById(cardId)
			.orElseThrow(() -> new IllegalArgumentException("해당 카드가 존재하지 않습니다."));

		List<Cowork> works = coworkRepository.findByCardId(cardId);
		works.forEach(coworkRepository::delete);

		cardRepository.delete(card);
	}

	@Override
	public CardResponseDto getCard(Long cardId) {
		Card card = cardRepository.findById(cardId)
			.orElseThrow(() -> new IllegalArgumentException("해당 카드가 존재하지 않습니다."));

		List<Long> members = cardRepository.getMemberIds(cardId);
		List<Long> labels = cardRepository.getLabelIds(cardId);

		return new CardResponseDto(card, members, labels);
	}
}
