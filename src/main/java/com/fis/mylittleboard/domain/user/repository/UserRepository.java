package com.fis.mylittleboard.domain.user.repository;

import com.fis.mylittleboard.domain.user.dto.SignupRequestDto;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

  boolean checksignupId(String signupId);

  void signIn(SignupRequestDto signupRequestDto);
}
