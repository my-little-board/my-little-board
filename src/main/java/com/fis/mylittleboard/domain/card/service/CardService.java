package com.fis.mylittleboard.domain.card.service;

import com.fis.mylittleboard.domain.card.dto.CardRequestDto;
import com.fis.mylittleboard.domain.card.dto.CoworkRequestDto;

public interface CardService {

	/**
	 *
	 * @param cardrequestDto
	 */

	void createCard(CardRequestDto cardrequestDto);

	void addWorkers(Long cardId, CoworkRequestDto coworkRequestDto);

	void updateCard(Long cardId, CardRequestDto cardRequestDto);
}
