package com.fis.mylittleboard.domain.card.service;

import com.fis.mylittleboard.domain.card.dto.CardColorResponseDto;
import com.fis.mylittleboard.domain.card.dto.CardDatesRequestDto;
import com.fis.mylittleboard.domain.card.dto.CardDatesResDto;
import com.fis.mylittleboard.domain.card.dto.CardDescriptionResponseDto;
import com.fis.mylittleboard.domain.card.dto.CardNameRequestDto;
import com.fis.mylittleboard.domain.card.dto.CardRequestDto;
import com.fis.mylittleboard.domain.card.dto.CardResponseDto;

public interface CardService {

	void createCard(CardNameRequestDto cardNameRequestDto);


	void deleteCard(Long cardId);

	CardResponseDto getCard(Long cardId);

	CardDescriptionResponseDto updateDescription(Long cardId, String description);

	CardColorResponseDto updateColor(Long cardId, String color);

	CardDatesResDto addDate(Long cardId, Long functionId, CardDatesRequestDto cardDatesRequestDto);

	CardDatesResDto updateDate(Long cardfunctionId, CardDatesRequestDto cardDatesRequestDto);

	void deleteDate(Long cardDateId);
}
