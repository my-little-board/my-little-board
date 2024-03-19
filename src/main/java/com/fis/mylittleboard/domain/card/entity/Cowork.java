package com.fis.mylittleboard.domain.card.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "coworks")
public class Cowork {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Long cardId;

	@Column
	private Long workerId;

	public Cowork(Long cardId, Long workerId) {
		this.cardId = cardId;
		this.workerId = workerId;
	}
}
