package com.fis.mylittleboard.domain.board.entity;

import com.fis.mylittleboard.domain.board.dto.BoardRequestDto;
import com.fis.mylittleboard.global.common.TimeStamp;
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
public class Board extends TimeStamp {

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

  @Column(nullable = false)
  private boolean classification = true;

  public Board(String boardName, String boardDescription, String boardColor, Long userId) {
    this.boardName = boardName;
    this.boardDescription = boardDescription;
    this.boardColor = boardColor;
    this.userId = userId;
  }

  public void update(BoardRequestDto requestDto) {
    this.boardName = requestDto.getBoardName();
    this.boardDescription = requestDto.getBoardDescription();
    this.boardColor = requestDto.getBoardColor();
    this.dueDate = LocalDateTime.now();
  }
}
