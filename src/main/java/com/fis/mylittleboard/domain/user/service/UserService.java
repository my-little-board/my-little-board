package com.fis.mylittleboard.domain.user.service;

import com.fis.mylittleboard.domain.user.dto.UserRequestDto;
import com.fis.mylittleboard.domain.user.dto.UserResponseDto;

public interface UserService{

  /**
   *
   * @param userRequestDto
   *
   */

  UserResponseDto signup(UserRequestDto userRequestDto);
}
