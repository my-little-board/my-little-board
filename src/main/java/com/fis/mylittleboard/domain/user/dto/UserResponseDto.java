package com.fis.mylittleboard.domain.user.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponseDto {
  private String signupId;
  private String username;
  private LocalDateTime createdAt;
  private LocalDateTime modifiedAt;

  public UserResponseDto(String signupId,String username,LocalDateTime createdAt, LocalDateTime modifiedAt) {
    this.signupId = signupId;
    this.username = username;
    this.createdAt = LocalDateTime.now();
    this.modifiedAt = LocalDateTime.now();
  }
}
