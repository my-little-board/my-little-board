package com.fis.mylittleboard.global.jwt.repository;

import com.fis.mylittleboard.global.jwt.entity.TokenEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenJpaRepository extends JpaRepository<TokenEntity, Long> {


  TokenEntity findByUserId(Long id);
  Optional<TokenEntity> findByToken(String token);

}
