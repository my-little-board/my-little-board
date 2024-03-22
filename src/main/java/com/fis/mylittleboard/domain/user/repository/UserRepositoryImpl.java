package com.fis.mylittleboard.domain.user.repository;

import com.fis.mylittleboard.domain.user.dto.UserRequestDto;
import com.fis.mylittleboard.domain.user.entity.UserEntity;
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
  public void signIn(UserRequestDto signupRequestDto) {
    userJpaRepository.save(UserEntity.of(signupRequestDto.getSignupId(),
        passwordEncoder.encode(signupRequestDto.getPassword()), signupRequestDto.getEmail(),
        signupRequestDto.getUsername()));
  }
}
