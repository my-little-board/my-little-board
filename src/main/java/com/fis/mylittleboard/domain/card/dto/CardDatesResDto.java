package com.fis.mylittleboard.domain.card.dto;

import com.fis.mylittleboard.domain.card.entity.Date;
import java.time.LocalDate;
import lombok.Getter;

@Getter
public class CardDatesResDto {

  private final LocalDate dueDate;

  public CardDatesResDto(Date date) {
    this.dueDate = date.getDueDate();
  }
}
