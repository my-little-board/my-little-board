package com.fis.mylittleboard.global.jwt.security;

import com.fis.mylittleboard.domain.user.model.User;
import com.fis.mylittleboard.domain.user.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserJpaRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String signupId) throws UsernameNotFoundException {
    User user = userRepository.findBySignupId(signupId)
        .orElseThrow(() -> new UsernameNotFoundException("Not Found " + signupId)).toModel();
    return new UserDetailsImpl(user);
  }
}
