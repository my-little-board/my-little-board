package com.fis.mylittleboard.domain.card.service;

import com.fis.mylittleboard.domain.card.dto.CardRequestDto;
import com.fis.mylittleboard.domain.card.dto.CardResponseDto;
import com.fis.mylittleboard.domain.card.entity.Card;
import com.fis.mylittleboard.domain.card.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardService {

	private final CardRepository cardRepository;

	public CardResponseDto createCard(CardRequestDto requestDto) {
		Card card = new Card(requestDto);
		cardRepository.save(card);
		return new CardResponseDto(card);
	}
}
