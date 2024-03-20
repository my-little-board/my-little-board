package com.fis.mylittleboard.domain.card.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;


@Getter
public class CardColorRequestDto {

  @NotNull
  private String color;

}
