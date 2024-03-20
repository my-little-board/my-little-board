package com.fis.mylittleboard.domain.user.service;

import static com.fis.mylittleboard.global.jwt.exception.CustomError.MEMBER_EXISTS;

import com.fis.mylittleboard.domain.user.dto.SignupRequestDto;
import com.fis.mylittleboard.domain.user.dto.UserRequestDto;
import com.fis.mylittleboard.domain.user.dto.UserResponseDto;
import com.fis.mylittleboard.domain.user.repository.UserRepository;
import com.fis.mylittleboard.global.jwt.exception.CustomException;
import com.fis.mylittleboard.global.jwt.repository.TokenRepository;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final TokenRepository tokenRepository;

  @Override
  public UserResponseDto signup(UserRequestDto userRequestDto) {

    SignupRequestDto signupRequestDto = SignupRequestDto.builder()
        .signupId(userRequestDto.getSignupId())
        .password(userRequestDto.getPassword())
        .email(userRequestDto.getEmail())
        .username(userRequestDto.getUsername())
        .build();

    if (userRepository.checksignupId(signupRequestDto.getSignupId())) {
      throw new CustomException(MEMBER_EXISTS);
    }

    userRepository.signIn(signupRequestDto);

    return UserResponseDto.builder()
        .signupId(signupRequestDto.getSignupId())
        .username(userRequestDto.getUsername())
        .createdAt(LocalDateTime.now())
        .modifiedAt(LocalDateTime.now()).build();
  }
}
