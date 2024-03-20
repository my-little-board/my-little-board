package com.fis.mylittleboard.domain.card.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dates")
public class Date {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private Long cardId;

	@Column
	private LocalDate dueDate;

	public Date(Long cardId, LocalDate dueDate) {
		this.cardId = cardId;
		this.dueDate = dueDate;
	}

	public void updateDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
}
