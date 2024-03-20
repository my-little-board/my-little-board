package com.fis.mylittleboard.domain.user.entity;

import com.fis.mylittleboard.domain.user.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 50)
  private String signupId;

  @Column(nullable = false, length = 100)
  private String password;

  @Column(nullable = false, length = 100)
  private String email;

  @Column(nullable = false, length = 50)
  private String username;

  @Column(nullable = false)
  @CreatedDate
  private LocalDateTime createdAt;

  @Column
  @LastModifiedDate
  private LocalDateTime modifiedAt;

  public static UserEntity of(String signupId, String password, String email, String username) {
    return UserEntity.builder()
        .signupId(signupId)
        .password(password)
        .email(email)
        .username(username)
        .createdAt(LocalDateTime.now())
        .modifiedAt(LocalDateTime.now())
        .build();
  }

  public User toModel() {
    return User.builder()
        .id(id)
        .signupId(signupId)
        .password(password)
        .email(email)
        .username(username)
        .build();
  }
}



