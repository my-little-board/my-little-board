package com.fis.mylittleboard.domain.user.service;

import com.fis.mylittleboard.domain.user.dto.UserRequestDto;
import com.fis.mylittleboard.domain.user.dto.UserResponseDto;
import com.fis.mylittleboard.domain.user.entity.User;
import com.fis.mylittleboard.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  public UserResponseDto createUser(UserRequestDto userRequestDto) {

    User user = User.toEntity(userRequestDto);
    userRepository.save(user);
    return new UserResponseDto(user);

  }




}
