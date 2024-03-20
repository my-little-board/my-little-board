package com.fis.mylittleboard.domain.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDto {
  private String signupId;
  private String password;
}
