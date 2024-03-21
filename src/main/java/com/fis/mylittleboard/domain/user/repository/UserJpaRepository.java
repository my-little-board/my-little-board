package com.fis.mylittleboard.domain.user.repository;

import com.fis.mylittleboard.domain.user.entity.UserEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {

  Optional<UserEntity> findBySignupId(String signupId);

  Optional<UserEntity> findByUsername(String username);
}
