package com.fis.mylittleboard.global.jwt.repository;

import com.fis.mylittleboard.global.jwt.entity.RefreshTokenEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository {


  void addRefreshToken(Long id, Long tokenId, String refreshToken);

  RefreshTokenEntity findByUserId(Long id);

  void deleteTokenByUserId(Long id);
}
