package com.fis.mylittleboard.domain.card.service;

import com.fis.mylittleboard.domain.card.dto.CardColorResponseDto;
import com.fis.mylittleboard.domain.card.dto.CardDatesRequestDto;
import com.fis.mylittleboard.domain.card.dto.CardDatesResDto;
import com.fis.mylittleboard.domain.card.dto.CardDescriptionResponseDto;
import com.fis.mylittleboard.domain.card.dto.CardNameRequestDto;
import com.fis.mylittleboard.domain.card.dto.CardResponseDto;
import com.fis.mylittleboard.domain.card.entity.Card;
import com.fis.mylittleboard.domain.card.entity.CardFunction;
import com.fis.mylittleboard.domain.card.entity.Date;
import com.fis.mylittleboard.domain.card.entity.Member;
import com.fis.mylittleboard.domain.card.repository.card.CardRepository;
import com.fis.mylittleboard.domain.card.repository.cardlabel.CardLabelRepository;
import com.fis.mylittleboard.domain.card.repository.cowork.CoworkRepository;
import com.fis.mylittleboard.domain.card.repository.date.DateRepository;
import com.fis.mylittleboard.domain.function.entity.Function;
import com.fis.mylittleboard.domain.function.repository.FunctionRepository;
import com.fis.mylittleboard.domain.label.repository.LabelRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

	private final CardRepository cardRepository;
	private final CoworkRepository coworkRepository;
	private final LabelRepository labelRepository;
	private final CardLabelRepository cardLabelRepository;
	private final DateRepository dateRepository;

	@Transactional
	@Override
	public void createCard(CardNameRequestDto cardNameRequestDto) {
		Card card = new Card(cardNameRequestDto);
		cardRepository.save(card);
	}


	@Transactional
	@Override
	public void deleteCard(Long cardId) {

		Card card = cardRepository.findById(cardId)
			.orElseThrow(() -> new IllegalArgumentException("해당 카드가 존재하지 않습니다."));

		List<Member> works = coworkRepository.findByCardId(cardId);
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

	@Transactional
	@Override
	public CardDescriptionResponseDto updateDescription(Long cardId, String description) {
		Card card = cardRepository.findById(cardId)
			.orElseThrow(() -> new IllegalArgumentException("해당 카드가 존재하지 않습니다."));

		card.updateDescription(description);
		return new CardDescriptionResponseDto(card);
	}

	@Transactional
	@Override
	public CardColorResponseDto updateColor(Long cardId, String color) {
		Card card = cardRepository.findById(cardId)
			.orElseThrow(() -> new IllegalArgumentException("해당 카드가 존재하지 않습니다."));

		card.updateColor(color);
		return new CardColorResponseDto(card);
	}

	@Transactional
	@Override
	public CardDatesResDto addDate(Long cardId,
		CardDatesRequestDto cardDatesRequestDto) {
		Card card = cardRepository.findById(cardId)
			.orElseThrow(() -> new IllegalArgumentException("해당 카드가 존재하지 않습니다."));

		Date date = new Date(cardId, cardDatesRequestDto.getDueDate());
		return new CardDatesResDto(date);
	}

	@Transactional
	@Override
	public CardDatesResDto updateDate(Long dateId,
		CardDatesRequestDto cardDatesRequestDto) {

		Date date = dateRepository.findById(dateId)
			.orElseThrow(() -> new IllegalArgumentException("해당 date는 존재하지 않습니다."));

		date.updateDate(cardDatesRequestDto.getDueDate());
		return new CardDatesResDto(date);
	}

	@Transactional
	@Override
	public void deleteDate(Long dateId) {
		Date date = dateRepository.findById(dateId)
			.orElseThrow(() -> new IllegalArgumentException("해당 date는 존재하지 않습니다."));
		dateRepository.delete(date);
	}
}
