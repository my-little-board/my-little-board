package com.fis.mylittleboard.domain.user.repository;

import com.fis.mylittleboard.domain.user.dto.SignupRequestDto;
import com.fis.mylittleboard.domain.user.entity.UserEntity;
import com.fis.mylittleboard.domain.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserRepositoryImpl implements UserRepository {

  private final UserJpaRepository userJpaRepository;
  private final PasswordEncoder passwordEncoder;

  @Override
  public boolean checksignupId(String signupId) {
    return userJpaRepository.findBySignupId(signupId).isPresent();
  }

  @Override
  public void signIn(SignupRequestDto signupRequestDto) {
    userJpaRepository.save(UserEntity.of(signupRequestDto.getSignupId(),
        passwordEncoder.encode(signupRequestDto.getPassword()), signupRequestDto.getEmail(),
        signupRequestDto.getUsername()));
  }

  @Override
  public User findByUsername(String username) {
    UserEntity userEntity = userJpaRepository.findByUsername(username)
        .orElseThrow(() -> new IllegalArgumentException("해당 이름의 유저는 없습니다."));
    return User.builder().username(userEntity.getUsername()).build();
  }
}
