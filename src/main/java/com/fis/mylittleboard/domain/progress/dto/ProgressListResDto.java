package com.fis.mylittleboard.domain.progress.dto;

import com.fis.mylittleboard.domain.card.dto.CardResponseDto;
import java.util.List;
import lombok.Getter;

@Getter
public class ProgressListResDto {

  private final String classification;

  private final List<CardResponseDto> cards;

  public ProgressListResDto(String classification, List<CardResponseDto> cards) {
    this.classification = classification;
    this.cards = cards;
  }

}
