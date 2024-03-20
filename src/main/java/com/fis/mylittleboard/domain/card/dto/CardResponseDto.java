package com.fis.mylittleboard.domain.card.dto;

import com.fis.mylittleboard.domain.card.entity.Card;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;

@Getter
public class CardResponseDto {

  private final Long cardId;

  private final String name;

  private final String description;

  private final String color;

  private LocalDate dueDate;

  private final Long boardId;

  private final Long progressId;

  private final List<Long> members;

  private final List<Long> labels;

  public CardResponseDto(Card card, List<Long> members, List<Long> labels) {
    this.cardId = card.getId();
    this.name = card.getName();
    this.description = card.getDescription();
    this.color = card.getColor();
    this.boardId = card.getBoardId();
    this.progressId = card.getProgressId();
    this.members = members;
    this.labels = labels;
  }
}
