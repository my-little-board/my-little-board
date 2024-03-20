package com.fis.mylittleboard.domain.board.dto;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class BoardResponseDto {

  private final String boardName;
  private final String boardDescription;
  private final String boardColor;
  private final LocalDateTime dueDate;

  public BoardResponseDto(
      String boardName, String boardDescription, String boardColor, LocalDateTime dueDate) {
    this.boardName = boardName;
    this.boardDescription = boardDescription;
    this.boardColor = boardColor;
    this.dueDate = dueDate;
  }
}
