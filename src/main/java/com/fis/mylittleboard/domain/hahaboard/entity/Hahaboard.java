package com.fis.mylittleboard.domain.hahaboard.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "hahaboard")
public class Hahaboard {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private Long InBoardId;

  @CreatedDate
  private LocalDateTime createdAt;

  public Hahaboard(Long id) {
    this.InBoardId = id;
    this.createdAt = LocalDateTime.now();
  }
}
