package com.fis.mylittleboard.global.jwt.repository;

import com.fis.mylittleboard.global.jwt.entity.RefreshTokenEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TokenRepositoryImpl implements TokenRepository {

  private final RefreshTokenJpaRepository refreshTokenJpaRepository;



  @Override
  public void deleteToken(RefreshTokenEntity token) {
    refreshTokenJpaRepository.deleteByToken(token.getToken());
  }

  @Override
  public void signup(Long userId, String refreshToken) {
    RefreshTokenEntity entity = RefreshTokenEntity.of(userId, refreshToken);
    refreshTokenJpaRepository.save(entity);
  }

  @Override
  public RefreshTokenEntity findByUserId(Long userId) {
    return refreshTokenJpaRepository.findByUserId(userId);
  }
}
