package com.fis.mylittleboard.domain.user.service;

import com.fis.mylittleboard.domain.user.dto.PasswordRequestDto;
import com.fis.mylittleboard.domain.user.dto.UserPasswordResponseDto;
import com.fis.mylittleboard.domain.user.dto.UserRequestDto;
import com.fis.mylittleboard.domain.user.dto.UserResponseDto;

public interface UserService {


  UserResponseDto signup(UserRequestDto userRequestDto);


  UserPasswordResponseDto updatePassword(Long id,PasswordRequestDto passwordRequestDto);
}
