package com.fis.mylittleboard.domain.card.dto;

import lombok.Getter;

@Getter
public class CardNameResDto {

	private String name;

	public CardNameResDto(String cardname) {
		this.name = cardname;
	}

}
