package com.fis.mylittleboard.domain.progress.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProgressRequestDto {

  @NotNull(message = "리스트 이름을 입력하세요.")
  private String classification;

}
