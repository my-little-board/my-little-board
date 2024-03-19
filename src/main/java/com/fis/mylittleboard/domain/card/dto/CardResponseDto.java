package com.fis.mylittleboard.domain.card.dto;

import com.fis.mylittleboard.domain.card.controller.CardController;
import com.fis.mylittleboard.domain.card.entity.Card;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@AllArgsConstructor
public class CardResponseDto {

	private Long cardId;

	private String name;

	private String description;

	private String color;

	private LocalDate dueDate;

	private Long boardId;

	private Long progressId;

	private List<Long> members;

	public CardResponseDto(Card card, List<Long> workers) {
		this.cardId = card.getId();
		this.name = card.getName();
		this.description = card.getDescription();
		this.color = card.getColor();
		this.dueDate = card.getDueDate();
		this.boardId = card.getBoardId();
		this.progressId = card.getProgressId();
		this.members = workers;
	}
}
