package com.fis.mylittleboard.domain.user.repository;

import com.fis.mylittleboard.domain.user.dto.SignupRequestDto;
import com.fis.mylittleboard.domain.user.entity.UserEntity;
import com.fis.mylittleboard.domain.user.model.User;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

  boolean checksignupId(String signupId);

  void signIn(SignupRequestDto signupRequestDto);

  User findByUsername(String username);
}
