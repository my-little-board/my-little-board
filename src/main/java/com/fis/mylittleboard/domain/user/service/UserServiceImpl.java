package com.fis.mylittleboard.domain.user.service;

import static com.fis.mylittleboard.global.jwt.exception.CustomError.MEMBER_EXISTS;

import com.fis.mylittleboard.domain.user.dto.PasswordRequestDto;
import com.fis.mylittleboard.domain.user.dto.UserEmailRequestDto;
import com.fis.mylittleboard.domain.user.dto.UserEmailResponseDto;
import com.fis.mylittleboard.domain.user.dto.UserPasswordResponseDto;
import com.fis.mylittleboard.domain.user.dto.UserRequestDto;
import com.fis.mylittleboard.domain.user.dto.UserResponseDto;
import com.fis.mylittleboard.domain.user.entity.UserEntity;
import com.fis.mylittleboard.domain.user.model.User;
import com.fis.mylittleboard.domain.user.repository.UserJpaRepository;
import com.fis.mylittleboard.domain.user.repository.UserRepository;
import com.fis.mylittleboard.global.jwt.exception.CustomError;
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
  public UserPasswordResponseDto updatePassword(Long id, PasswordRequestDto passwordRequestDto) {

    UserEntity user = findByUserId(id);

    if (!passwordEncoder.matches(passwordRequestDto.getPassword(), user.getPassword())) {
      throw new IllegalArgumentException("변경전 비밀번호와 일치하지 않습니다.");
    }

    String newEncodedPassword = passwordEncoder.encode(passwordRequestDto.getNewPassword());
    user.changePassword(newEncodedPassword);

    userJpaRepository.save(user);

    return UserPasswordResponseDto.builder()
        .newPassword(passwordRequestDto.getNewPassword())
        .build();
  }

  @Override
  public UserEmailResponseDto updateEmail(Long id, UserEmailRequestDto userEmailRequestDto) {
    UserEntity user = findByUserId(id);

    if (!userEmailRequestDto.getEmail().matches(user.getEmail())) {
      throw new IllegalArgumentException("변경전 이메일과 일치하지 않습니다.");
    }
    String newEmail = userEmailRequestDto.getNewEmail();
    user.changeEmail(newEmail);

    userJpaRepository.save(user);

    return UserEmailResponseDto.builder().newEmail(userEmailRequestDto.getNewEmail()).build();
  }

  @Override
  public void deleteUser(Long id) {

    UserEntity user = findByUserId(id);
    userJpaRepository.deleteById(user.getId());
    tokenRepository.deleteTokenByUserId(id);
  }

  private UserEntity findByUserId(Long id) {
    return userJpaRepository.findById(id)
        .orElseThrow(() -> new CustomException(CustomError.MEMBER_NOT_EXISTS));
  }


}
