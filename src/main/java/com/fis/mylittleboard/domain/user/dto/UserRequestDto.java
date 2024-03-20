package com.fis.mylittleboard.domain.user.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserRequestDto {

  private String signupId;

  private String password;

  private String email;

  private String username;

}
