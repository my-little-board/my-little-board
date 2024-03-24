package com.fis.mylittleboard.domain.progress.dto;

import com.fis.mylittleboard.domain.progress.entity.Progress;
import lombok.Getter;

@Getter
public class ProgressResDto {

  private final Long progressId;

  private final String classification;

  private final Long boardId;

  private final Long position;

  public ProgressResDto(Progress progress) {
    this.progressId = progress.getId();
    this.classification = progress.getClassification();
    this.boardId = progress.getBoardId();
    this.position = progress.getPosition();
  }

}
