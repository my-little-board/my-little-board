package com.fis.mylittleboard.global.jwt.success;

import lombok.Getter;

@Getter
public enum SuccessCode {
  // JWT 성공 메세지
  SUCCESS_NEW_TOKEN("성공적으로 토큰을 발급하였습니다."),

  // 유저 성공 메세지
  SUCCESS_SIGNUP("회원 가입에 성공하였습니다."),
  SUCCESS_LOGIN("로그인에 성공하였습니다."),
  SUCCESS_LOGOUT("로그아웃에 성공하였습니다."),
  SUCCESS_SEARCH("조회에 성공하였습니다."),
  SUCCESS_UPDATE_MEMBER("회원 정보를 성공적으로 변경하였습니다."),
  SUCCESS_UPDATE_MEMBER_PASSWORD("회원의 비밀번호를 변경하였습니다."),
  SUCCESS_DELETE_MEMBER("회원을 성공적으로 삭제하였습니다.");
  private final String message;

  SuccessCode(String message) {
    this.message = message;
  }
}
