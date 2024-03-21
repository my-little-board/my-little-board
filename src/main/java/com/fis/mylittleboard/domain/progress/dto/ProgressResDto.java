package com.fis.mylittleboard.domain.progress.dto;

import com.fis.mylittleboard.domain.progress.entity.Progress;
import lombok.Getter;

@Getter
public class ProgressResDto {

	private Long progressId;

	private String classification;

	private Long boardId;

	private Long position;

	public ProgressResDto(Progress progress) {
		this.progressId = progress.getId();
		this.classification = progress.getClassification();
		this.boardId = progress.getBoardId();
		this.position = progress.getPosition();
	}

}
