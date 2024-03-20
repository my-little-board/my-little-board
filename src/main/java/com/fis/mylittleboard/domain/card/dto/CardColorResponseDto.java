package com.fis.mylittleboard.domain.card.dto;

import com.fis.mylittleboard.domain.card.entity.Card;
import lombok.Getter;

@Getter
public class CardColorResponseDto {

  private final String color;

  public CardColorResponseDto(Card card) {
    this.color = card.getColor();
  }

}
