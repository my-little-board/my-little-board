package com.fis.mylittleboard.domain.card.dto;

import lombok.Getter;

@Getter
public class MemberResDto {

  private final String username;

  public MemberResDto(String username) {
    this.username = username;
  }

}
