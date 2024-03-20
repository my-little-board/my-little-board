package com.fis.mylittleboard.domain.card.service;

import com.fis.mylittleboard.domain.card.dto.CardRequestDto;
import com.fis.mylittleboard.domain.card.dto.CardResponseDto;

public interface CardService {

	/**
	 *
	 * @param cardrequestDto
	 */

	void createCard(CardRequestDto cardrequestDto);

	void updateCard(Long cardId, CardRequestDto cardRequestDto);

	void deleteCard(Long cardId);

	CardResponseDto getCard(Long cardId);

	void addLabel(Long cardId, Long labelId);
}
