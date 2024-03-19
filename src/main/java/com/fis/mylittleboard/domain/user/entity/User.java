package com.fis.mylittleboard.domain.user.entity;

import com.fis.mylittleboard.domain.user.dto.UserRequestDto;
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
public class User {

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

  @Builder
  public User(Long id,String signupId,String password,String email,String username){
    this.id = id;
    this.signupId = signupId;
    this.password = password;
    this.email = email;
    this.username = username;
    this.createdAt = LocalDateTime.now();
  }



  public void User(User user) {
    this.signupId = user.signupId;
    this.password = user.password;
    this.email = user.email;
    this.username = user.username;
    this.modifiedAt = user.modifiedAt;
  }
  public static User toEntity(UserRequestDto userRequestDto) {
    return User.builder()
        .signupId(userRequestDto.getSignupId())
        .password(userRequestDto.getPassword())
        .email(userRequestDto.getEmail())
        .username(userRequestDto.getUsername()).createdAt(LocalDateTime.now()).build();
  }

}
