package com.fis.mylittleboard.domain.card.dto;

import com.fis.mylittleboard.domain.card.entity.Card;
import java.time.LocalDate;
import lombok.Getter;

@Getter
public class CardDatesResDto {

	private LocalDate dueDate;

	public CardDatesResDto(Card card) {
		this.dueDate = card.getDueDate();
	}
}
