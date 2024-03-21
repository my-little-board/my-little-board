package com.fis.mylittleboard.domain.card.dto;

import com.fis.mylittleboard.domain.card.entity.Card;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import lombok.Builder;
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

  @Builder
  public CardResponseDto(Card card, List<Long> members, List<Long> labels, LocalDate dueDate) {
    this.cardId = card.getId();
    this.name = card.getName();
    this.description = card.getDescription();
    this.color = card.getColor();
    this.dueDate = dueDate;
    this.boardId = card.getBoardId();
    this.progressId = card.getProgressId();
    this.members = members;
    this.labels = labels;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CardResponseDto that = (CardResponseDto) o;
    return Objects.equals(cardId, that.cardId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cardId);
  }
}
