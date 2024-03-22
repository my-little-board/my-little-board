package com.fis.mylittleboard.domain.progress.dto;

import java.util.List;
import lombok.Getter;

@Getter
public class ProgressAllList {

  private final List<ProgressListResDto> cards;

  public ProgressAllList(List<ProgressListResDto> progressListResDtos) {
    this.cards = progressListResDtos;
  }
}
