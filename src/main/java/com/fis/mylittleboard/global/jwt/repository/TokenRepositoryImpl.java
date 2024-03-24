package com.fis.mylittleboard.global.jwt.repository;

import com.fis.mylittleboard.global.jwt.entity.TokenEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TokenRepositoryImpl implements TokenRepository {

  private final TokenJpaRepository tokenJpaRepository;


  @Override
  public void deleteTokenByUserId(Long userId) {
    TokenEntity refreshTokenEntity = findByUserId(userId);
    if (refreshTokenEntity != null) {
      tokenJpaRepository.deleteById(refreshTokenEntity.getId());
    }
  }

  @Override
  public void update(TokenEntity token) {
    tokenJpaRepository.saveAndFlush(token);
  }



  @Override
  public void addRefreshToken(Long id,Long userId, String refreshToken) {
    TokenEntity entity = TokenEntity.of(id,userId, refreshToken);
    tokenJpaRepository.save(entity);
  }

  @Override
  public TokenEntity findByUserId(Long userId) {
    return tokenJpaRepository.findByUserId(userId);
  }

}
