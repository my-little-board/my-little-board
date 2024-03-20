package com.fis.mylittleboard.domain.card.dto;

import com.fis.mylittleboard.domain.card.entity.Card;
import com.fis.mylittleboard.domain.card.entity.Date;
import java.time.LocalDate;
import lombok.Getter;

@Getter
public class CardDatesResDto {

	private LocalDate dueDate;

	public CardDatesResDto(Date date) {
		this.dueDate = date.getDueDate();
	}
}
