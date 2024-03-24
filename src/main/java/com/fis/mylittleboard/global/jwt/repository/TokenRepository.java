package com.fis.mylittleboard.global.jwt.repository;

import com.fis.mylittleboard.global.jwt.entity.TokenEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository {


  void addRefreshToken(Long id,Long tokenId, String refreshToken);

  TokenEntity findByUserId(Long id);

  void deleteTokenByUserId(Long id);
  void update(TokenEntity token);
}
