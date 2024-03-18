package com.fis.mylittleboard.domain.board.entity;

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
@Getter
@NoArgsConstructor
@Table(name = "boards")
public class Board {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String boardName;

  @Column(nullable = false)
  private String boardDescription;

  @Column(nullable = false)
  private String boardColor;

  @Column(nullable = false)
  private Long userId;

  @CreatedDate
  @Column(nullable = false)
  private LocalDateTime dueDate = LocalDateTime.now();
  // todo: 마감기한 설정하는 방법은 나중에 기능구현이 끝나면 생각해보기..

  @Column(nullable = false)
  private boolean classification;

  public Board(String boardName, String boardDescription, String boardColor, Long userId) {
    this.boardName = boardName;
    this.boardDescription = boardDescription;
    this.boardColor = boardColor;
    this.userId = userId;
  }

  // todo: patch api가 필요 url path에
}
