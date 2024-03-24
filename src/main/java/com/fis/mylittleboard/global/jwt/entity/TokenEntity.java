package com.fis.mylittleboard.global.jwt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Table(name = "refresh_token")
@Entity
public class TokenEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long userId;
  private String token;
  private Boolean isExpired;

  protected TokenEntity() {

  }

  private TokenEntity(Long id,Long userId, String token) {
    this.id = id;
    this.userId = userId;
    this.token = token;
  }

  public static TokenEntity of(Long id,Long userId, String token) {
    return new TokenEntity(id, userId, token);
  }

  public void expireToken() {
    isExpired = true;
  }
}
