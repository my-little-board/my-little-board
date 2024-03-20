package com.fis.mylittleboard.global.jwt.exception;

import lombok.Getter;

@Getter
public enum CustomError {
  // 회원에 대한 오류
  NO_AUTH("해당 유저의 권한이 없습니다."),
  MEMBER_EXISTS("해당 유저가 존재합니다."),
  MEMBER_NOT_EXISTS("해당 유저가 존재하지 않습니다."),
  PASSWORD_EQUALS("현재 비밀번호입니다."),
  PASSWORD_ERROR("비밀번호가 일치하지 않습니다."),
  CHANGE_PASSWORD_ERROR("변경할 비밀번호가 서로 일치하지 않습니다."),
  CURRENT_PASSWORD_ERROR("최근에 해당 비밀번호로 변경한 적이 있습니다."),
  ERROR_LOGIN("로그인에 실패하였습니다."),

  // JWT 토큰 에러
  EXPIRED_TOKEN("모든 토큰이 만료되었습니다.");

  private final String message;

  CustomError(String message) {
    this.message = message;
  }
}

