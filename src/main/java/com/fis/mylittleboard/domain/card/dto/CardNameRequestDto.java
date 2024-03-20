package com.fis.mylittleboard.domain.card.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class CardNameRequestDto {

	@NotNull(message = "카드 제목을 입력하세요")
	private String name;

	@NotNull
	private Long boardId;

	@NotNull
	private Long progressId;

}
