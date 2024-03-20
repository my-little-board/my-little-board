package com.fis.mylittleboard.domain.card.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class MemberReqDto {

  @NotNull(message = "추가하고자 하는 member를 입력하세요")
  private String username;

}
