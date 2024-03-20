package com.fis.mylittleboard.domain.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

  private Long id;
  private String signupId;
  private String password;
  private String email;
  private String username;

}
