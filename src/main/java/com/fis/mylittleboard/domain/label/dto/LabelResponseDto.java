package com.fis.mylittleboard.domain.label.dto;

import com.fis.mylittleboard.domain.label.entity.Label;
import lombok.Getter;

@Getter
public class LabelResponseDto {

	private String title;

	private String color;

	public LabelResponseDto(Label label) {
		this.title = label.getTitle();
		this.color = label.getColor();
	}


}
