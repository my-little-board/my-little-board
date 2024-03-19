package com.fis.mylittleboard.domain.card.service;

import com.fis.mylittleboard.domain.card.dto.CardRequestDto;

public interface CardService {

	/**
	 *
	 * @param cardrequestDto
	 */

	void createCard(CardRequestDto cardrequestDto);

	void updateCard(Long cardId, CardRequestDto cardRequestDto);

	void deleteCard(Long cardId);
}
