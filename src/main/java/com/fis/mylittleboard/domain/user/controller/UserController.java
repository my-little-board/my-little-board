package com.fis.mylittleboard.domain.user.controller;

import com.fis.mylittleboard.domain.user.dto.UserRequestDto;
import com.fis.mylittleboard.domain.user.dto.UserResponseDto;
import com.fis.mylittleboard.domain.user.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

  private final UserServiceImpl userServiceImpl;

  @PostMapping("/users/signup")
  public UserResponseDto createUser(@RequestBody UserRequestDto userRequestDto) {
    return userServiceImpl.createUser(userRequestDto);
  }
}
