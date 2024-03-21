package com.fis.mylittleboard.domain.progress.dto;

import com.fis.mylittleboard.domain.card.dto.CardResponseDto;
import com.fis.mylittleboard.domain.card.entity.Card;
import java.util.HashMap;
import java.util.List;
import lombok.Getter;

@Getter
public class ProgressListResDto {

	private String classification;

	private List<CardResponseDto> cards;

	public ProgressListResDto(String classification, List<CardResponseDto> cards) {
		this.classification = classification;
		this.cards = cards;
	}

}
