package com.fis.mylittleboard.domain.board.dto;

import com.fis.mylittleboard.domain.hahacontent.entity.HahaContent;
import com.fis.mylittleboard.domain.progress.entity.Progress;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;

@Getter
public class BoardResponseDto {

  private final String boardName;
  private final String boardDescription;
  private final String boardColor;
  private final LocalDateTime dueDate;

  private final String hahaboardName;
  private final List<HahaContent> hahaContents;
  private final List<Progress> progresses;

  public BoardResponseDto(
      String boardName, String boardDescription, String boardColor, LocalDateTime dueDate,
      List<Progress> progresses, String hahaboardName, List<HahaContent> hahaContents
  ) {
    this.boardName = boardName;
    this.boardDescription = boardDescription;
    this.boardColor = boardColor;
    this.dueDate = dueDate;
    this.progresses = progresses;
    this.hahaboardName = hahaboardName;
    this.hahaContents = hahaContents;
  }
}
