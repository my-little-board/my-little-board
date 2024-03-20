package com.fis.mylittleboard.domain.card.dto;

import com.fis.mylittleboard.domain.card.entity.Card;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class CardColorResponseDto {

	private String color;

	public CardColorResponseDto(Card card) {
		this.color = card.getColor();
	}

}
