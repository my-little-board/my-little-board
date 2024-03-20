package com.fis.mylittleboard.domain.label.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LabelRequestDto {

  private String title;

  @NotNull(message = "만들고자 하는 label의 색상을 입력하세요.")
  private String color;

}
