package com.fis.mylittleboard.global.jwt.security;

import static com.fis.mylittleboard.global.jwt.success.SuccessCode.SUCCESS_LOGIN;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fis.mylittleboard.domain.user.dto.LoginRequestDto;
import com.fis.mylittleboard.domain.user.model.User;
import com.fis.mylittleboard.global.jwt.JwtProvider;
import com.fis.mylittleboard.global.jwt.dto.CommonResponseDto;
import com.fis.mylittleboard.global.jwt.exception.CustomError;
import com.fis.mylittleboard.global.jwt.repository.TokenRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Slf4j(topic = "로그인 및 JWT 생성")
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

  private final JwtProvider jwtUtil;
  private final TokenRepository tokenRepository;

  ObjectMapper objectMapper = new ObjectMapper();

  public JwtAuthenticationFilter(JwtProvider jwtUtil, TokenRepository tokenRepository) {
    this.jwtUtil = jwtUtil;
    this.tokenRepository = tokenRepository;
    setFilterProcessesUrl("/api/users/login");

  }

  @Override
  public Authentication attemptAuthentication(
      HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
    try {
      LoginRequestDto requestDto = new ObjectMapper().readValue(request.getInputStream(),
          LoginRequestDto.class);

      return getAuthenticationManager().authenticate(
          new UsernamePasswordAuthenticationToken(
              requestDto.getSignupId(),
              requestDto.getPassword(),
              null
          )
      );
    } catch (IOException e) {
      log.error(e.getMessage());
      throw new RuntimeException(e.getMessage());
    }
  }

  @Override
  protected void successfulAuthentication(
      HttpServletRequest request, HttpServletResponse response, FilterChain chain,
      Authentication authResult)
      throws IOException {
    User user = ((UserDetailsImpl) authResult.getPrincipal()).getUser();

    String token = jwtUtil.generateAccessToken(user.getSignupId());
    String refreshToken = jwtUtil.generateRefreshToken(user.getSignupId());
    refreshToken = jwtUtil.substringToken(refreshToken);

    tokenRepository.signup(user.getId(), refreshToken);

    response.addHeader(JwtProvider.AUTHORIZATION_ACCESS_TOKEN_HEADER_KEY, token);
    response.setStatus(HttpServletResponse.SC_OK);

    String jsonResponse = objectMapper.writeValueAsString(
        CommonResponseDto.ok(SUCCESS_LOGIN, null));

    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write(jsonResponse);
  }

  @Override
  protected void unsuccessfulAuthentication(
      HttpServletRequest request, HttpServletResponse response, AuthenticationException failed)
      throws IOException {
    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    String jsonResponse = objectMapper.writeValueAsString(
        CommonResponseDto.badRequest(CustomError.ERROR_LOGIN.getMessage()));

    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write(jsonResponse);
  }

}
