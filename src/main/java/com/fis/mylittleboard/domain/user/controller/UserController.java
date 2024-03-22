package com.fis.mylittleboard.domain.user.controller;

import com.fis.mylittleboard.domain.user.dto.PasswordRequestDto;
import com.fis.mylittleboard.domain.user.dto.UserPasswordResponseDto;
import com.fis.mylittleboard.domain.user.dto.UserRequestDto;
import com.fis.mylittleboard.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    return "유저를 생성하였습니다";
  }

  @PutMapping("/users/{id}/password")
  public UserPasswordResponseDto updatePassword(@PathVariable Long id,@RequestBody PasswordRequestDto passwordRequestDto)
  {
    UserPasswordResponseDto userResponseDto = userService.updatePassword(id,passwordRequestDto);
    return userResponseDto;
  }
//  @PutMaaping("/users/email")


}
