package com.fis.mylittleboard.domain.user.service;

import static com.fis.mylittleboard.global.jwt.exception.CustomError.MEMBER_EXISTS;

import com.fis.mylittleboard.domain.user.dto.PasswordRequestDto;
import com.fis.mylittleboard.domain.user.dto.UserPasswordResponseDto;
import com.fis.mylittleboard.domain.user.dto.UserRequestDto;
import com.fis.mylittleboard.domain.user.dto.UserResponseDto;
import com.fis.mylittleboard.domain.user.entity.UserEntity;
import com.fis.mylittleboard.domain.user.model.User;
import com.fis.mylittleboard.domain.user.repository.UserJpaRepository;
import com.fis.mylittleboard.domain.user.repository.UserRepository;
import com.fis.mylittleboard.global.jwt.exception.CustomException;
import com.fis.mylittleboard.global.jwt.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final UserJpaRepository userJpaRepository;
  private final TokenRepository tokenRepository;
  private final PasswordEncoder passwordEncoder;

  @Override
  public UserResponseDto signup(UserRequestDto signupRequestDto) {
    User user = User.builder()
        .signupId(signupRequestDto.getSignupId())
        .password(signupRequestDto.getPassword())
        .email(signupRequestDto.getEmail())
        .username(signupRequestDto.getUsername())
        .build();

    if (userRepository.checksignupId(user.getSignupId())) {
      throw new CustomException(MEMBER_EXISTS);
    }

    //이메일 검증추가

    userRepository.signIn(signupRequestDto);

    return UserResponseDto.builder()
        .signupId(user.getSignupId())
        .username(user.getUsername())
        .build();
  }

  @Override
  public UserPasswordResponseDto updatePassword(Long id,PasswordRequestDto passwordRequestDto) {

    UserEntity user = userJpaRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("해당 id의 사용자가 없습니다."));

    if (!passwordEncoder.matches(passwordRequestDto.getPassword(), user.getPassword())) {
      throw new IllegalArgumentException("이전 비밀번호가 일치하지 않습니다.");
    }

    String newEncodedPassword = passwordEncoder.encode(passwordRequestDto.getNewPassword());
    user.changePassword(newEncodedPassword);

    userJpaRepository.save(user);

    return UserPasswordResponseDto.builder()
        .newPassword(passwordRequestDto.getNewPassword())
        .build();
  }


}
