package com.fis.mylittleboard.domain.user.dto;

import com.fis.mylittleboard.domain.user.entity.User;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class UserResponseDto {
  private long id;
  private String signupId;
  private String email;
  private String username;
  private LocalDateTime createdAt;
  public UserResponseDto(User user) {
    this.id = user.getId();
    this.signupId = user.getSignupId();
    this.email = user.getEmail();
    this.username = user.getUsername();
    this.createdAt = user.getCreatedAt();
  }
}
