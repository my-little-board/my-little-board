package com.fis.mylittleboard.domain.board.dto;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class BoardResponseDto {
  private String boardName;
  private String boardDescription;
  private String boardColor;
  private LocalDateTime dueDate;

  // todo: 진행상황을 %로 계산해서 100%가 아니면 false를 가져가고 반환은 진행중이라 반환하게 해야 되나...?
}
