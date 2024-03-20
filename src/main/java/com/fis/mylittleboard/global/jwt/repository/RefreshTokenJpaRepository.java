package com.fis.mylittleboard.global.jwt.repository;

import com.fis.mylittleboard.global.jwt.entity.RefreshTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenJpaRepository extends JpaRepository<RefreshTokenEntity, Long> {


  RefreshTokenEntity findByUserId(Long id);

  void deleteByToken(String token);

}
