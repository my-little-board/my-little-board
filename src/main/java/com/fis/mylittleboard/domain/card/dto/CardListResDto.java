package com.fis.mylittleboard.domain.card.dto;

import java.util.List;
import lombok.Getter;

@Getter
public class CardListResDto {

  private final List<CardResponseDto> cardResponseDtos;

  public CardListResDto(List<CardResponseDto> cardResponseDtos) {
    this.cardResponseDtos = cardResponseDtos;
  }

}
