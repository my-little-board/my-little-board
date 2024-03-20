package com.fis.mylittleboard.domain.card.dto;

import com.fis.mylittleboard.domain.card.entity.Card;
import lombok.Getter;

@Getter
public class CardDescriptionResponseDto {

  private final String description;

  public CardDescriptionResponseDto(Card card) {
    this.description = card.getDescription();
  }

}
