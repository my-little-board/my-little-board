package com.fis.mylittleboard.domain.hahaboard.entity;

import com.fis.mylittleboard.global.common.TimeStamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "hahaboard")
public class Hahaboard extends TimeStamp {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String hahaboardName;

  @Column(nullable = false)
  private Long inBoardId;

  public Hahaboard(Long id, String hahaboardName) {
    this.inBoardId = id;
    this.hahaboardName = hahaboardName;
  }
}
