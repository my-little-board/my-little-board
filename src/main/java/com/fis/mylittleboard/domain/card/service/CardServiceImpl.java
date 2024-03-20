package com.fis.mylittleboard.domain.card.service;

import com.fis.mylittleboard.domain.card.dto.CardColorResponseDto;
import com.fis.mylittleboard.domain.card.dto.CardDescriptionResponseDto;
import com.fis.mylittleboard.domain.card.dto.CardNameRequestDto;
import com.fis.mylittleboard.domain.card.dto.CardRequestDto;
import com.fis.mylittleboard.domain.card.dto.CardResponseDto;
import com.fis.mylittleboard.domain.card.entity.Card;
import com.fis.mylittleboard.domain.card.entity.CardLabel;
import com.fis.mylittleboard.domain.card.entity.CardMember;
import com.fis.mylittleboard.domain.card.repository.card.CardRepository;
import com.fis.mylittleboard.domain.card.repository.cardlabel.CardLabelRepository;
import com.fis.mylittleboard.domain.card.repository.cowork.CoworkRepository;
import com.fis.mylittleboard.domain.function.entity.Function;
import com.fis.mylittleboard.domain.label.repository.LabelRepository;
import java.util.ArrayList;
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
	public void createCard(CardNameRequestDto cardNameRequestDto) {
		Card card = new Card(cardNameRequestDto);
		cardRepository.save(card);
	}


	@Override
	public void deleteCard(Long cardId) {

		Card card = cardRepository.findById(cardId)
			.orElseThrow(() -> new IllegalArgumentException("해당 카드가 존재하지 않습니다."));

		List<CardMember> works = coworkRepository.findByCardId(cardId);
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

	@Override
	public CardDescriptionResponseDto updateDescription(Long cardId, String description) {
		Card card = cardRepository.findById(cardId)
			.orElseThrow(() -> new IllegalArgumentException("해당 카드가 존재하지 않습니다."));

		card.updateDescription(description);
		return new CardDescriptionResponseDto(card);
	}

	@Override
	public CardColorResponseDto updateColor(Long cardId, String color) {
		Card card = cardRepository.findById(cardId)
			.orElseThrow(() -> new IllegalArgumentException("해당 카드가 존재하지 않습니다."));

		card.updateColor(color);
		return new CardColorResponseDto(card);
	}
}
