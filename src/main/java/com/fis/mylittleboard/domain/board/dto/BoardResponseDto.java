package com.fis.mylittleboard.domain.board.dto;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class BoardResponseDto {

  private final String boardName;
  private final String boardDescription;
  private final String boardColor;
  private final LocalDateTime dueDate;

  // todo: 진행상황을 %로 계산해서 100%가 아니면 false를 가져가고 반환은 진행중이라 반환하게 해야 되나...?

  public BoardResponseDto(
      String boardName, String boardDescription, String boardColor, LocalDateTime dueDate) {
    this.boardName = boardName;
    this.boardDescription = boardDescription;
    this.boardColor = boardColor;
    this.dueDate = dueDate;
  }
}
