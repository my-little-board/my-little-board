package com.fis.mylittleboard.domain.user.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserPasswordResponseDto {
  private String newPassword;
}
