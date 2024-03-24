package com.fis.mylittleboard.global.jwt.repository;

import com.fis.mylittleboard.global.jwt.entity.RefreshTokenEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TokenRepositoryImpl implements TokenRepository {

  private final RefreshTokenJpaRepository refreshTokenJpaRepository;


  @Override
  public void deleteTokenByUserId(Long userId) {
    RefreshTokenEntity refreshToken = findByUserId(userId);
    if (refreshToken != null) {
      refreshTokenJpaRepository.deleteById(refreshToken.getId());
    }
  }

  @Override
  public void addRefreshToken(Long id, Long userId, String refreshToken) {
    RefreshTokenEntity entity = RefreshTokenEntity.of(id, userId, refreshToken);
    refreshTokenJpaRepository.save(entity);
  }

  @Override
  public RefreshTokenEntity findByUserId(Long userId) {
    return refreshTokenJpaRepository.findByUserId(userId);
  }
}
