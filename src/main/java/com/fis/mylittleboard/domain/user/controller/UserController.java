package com.fis.mylittleboard.domain.user.controller;

import com.fis.mylittleboard.domain.user.dto.PasswordRequestDto;
import com.fis.mylittleboard.domain.user.dto.UserEmailRequestDto;
import com.fis.mylittleboard.domain.user.dto.UserRequestDto;
import com.fis.mylittleboard.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @PostMapping("/users/signup")
  public String signup(@RequestBody UserRequestDto userRequestDto) {

    userService.signup(userRequestDto);
    return "회원가입 완료";
  }

  @PutMapping("/users/{id}/password")
  public String updatePassword(@PathVariable Long id,@RequestBody PasswordRequestDto passwordRequestDto)
  {
    userService.updatePassword(id,passwordRequestDto);
    return "비밀번호 변경 성공";
  }
  @PutMapping("/users/{id}/email")
  public String updateEmail(@PathVariable Long id,@RequestBody UserEmailRequestDto userEmailRequestDto){
    userService.updateEmail(id,userEmailRequestDto);
    return "이메일 변경 성공";
  }
  @DeleteMapping("/users/{id}/secession")
  public String deleteUser(@PathVariable Long id){
    userService.deleteUser(id);
    return "회원이 탈퇴 되었습니다";
  }
  @PatchMapping("/users/logout")
  public String logout(@RequestHeader(value = "Authorization") String token){
    userService.logout(token);
    return "로그아웃 성공";
  }

}
