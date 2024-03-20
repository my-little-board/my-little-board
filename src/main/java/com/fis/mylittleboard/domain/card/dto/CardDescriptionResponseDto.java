package com.fis.mylittleboard.domain.card.dto;

import com.fis.mylittleboard.domain.card.entity.Card;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class CardDescriptionResponseDto {

	private String description;

	public CardDescriptionResponseDto(Card card) {
		this.description = card.getDescription();
	}

}
