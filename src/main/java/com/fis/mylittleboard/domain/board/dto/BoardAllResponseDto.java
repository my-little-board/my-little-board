package com.fis.mylittleboard.domain.board.dto;

import lombok.Getter;

@Getter
public class BoardAllResponseDto {

  private final String boardStatus;
  private final String boardName;

  public BoardAllResponseDto(Boolean boardStatus, String boardName) {
    if (boardStatus) {
      this.boardStatus = "현재 진행 중인 워크스페이스";
    } else {
      this.boardStatus = "마감된 워크스페이스";
    }
    this.boardName = boardName;
  }
}
