package com.fis.mylittleboard.domain.card.entity;

import com.fis.mylittleboard.domain.card.dto.CardRequestDto;
import com.fis.mylittleboard.global.common.TimeStamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cards")
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column
	private String description;

	@Column(nullable = false)
	private String color;

	@Column(nullable = false)
	private LocalDate dueDate;

	@Column(nullable = false)
	private Long boardId;

	@Column(nullable = false)
	private Long progressId;

	@Builder
	public Card(CardRequestDto cardRequestDto) {
		this.name = cardRequestDto.getName();
		this.description = cardRequestDto.getName();
		this.color = cardRequestDto.getColor();
		this.dueDate = cardRequestDto.getDueDate();
		this.boardId = cardRequestDto.getBoardId();
		this.progressId = cardRequestDto.getProgressId();
	}
}
