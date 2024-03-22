package com.fis.mylittleboard.domain.progress.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ProgressMoveDto {

	@NotNull
	private Long boardId;

	@NotNull
	private Long position;

}
