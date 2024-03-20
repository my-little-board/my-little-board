package com.fis.mylittleboard.domain.card.entity;

import com.fis.mylittleboard.domain.card.dto.CardNameRequestDto;
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

	@Column
	private String color;

	@Column
	private LocalDate dueDate;

	@Column(nullable = false)
	private Long boardId;

	@Column(nullable = false)
	private Long progressId;


	@Builder
	public Card(CardNameRequestDto cardNameRequestDto) {
		this.name = cardNameRequestDto.getName();
		this.color = "default color";
		this.boardId = cardNameRequestDto.getBoardId();
		this.progressId = cardNameRequestDto.getProgressId();
	}

	public void updateDescription(String description) {
		this.description = description;
	}

	public void updateColor(String color) {
		this.color = color;
	}

}
