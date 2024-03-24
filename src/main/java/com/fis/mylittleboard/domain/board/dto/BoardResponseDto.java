package com.fis.mylittleboard.domain.board.dto;

import lombok.Getter;

@Getter
public class BoardResponseDto {

  private final String boardName;
  private final String boardDescription;
  private final String boardStatus;

  private final String boardColor;

  public BoardResponseDto(
      Boolean boardStatus, String boardName, String boardDescription, String boardColor) {
    if (boardStatus) {
      this.boardStatus = "작업 중인 워크스페이스";
    } else {
      this.boardStatus = "마감된 워크스페이스";
    }
    this.boardName = boardName;
    this.boardDescription = boardDescription;
    this.boardColor = boardColor;
  }
}
