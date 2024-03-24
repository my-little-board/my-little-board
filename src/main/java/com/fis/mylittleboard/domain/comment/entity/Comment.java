package com.fis.mylittleboard.domain.comment.entity;

import com.fis.mylittleboard.domain.comment.dto.CommentRequestDto;
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
@Getter
@NoArgsConstructor
@Table(name = "comments")
public class Comment extends TimeStamp {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String content;

  @Column(nullable = false)
  private Long cardId;

  @Column(nullable = false)
  private Long userId;

  public Comment(CommentRequestDto requestDto, Long cardId, Long userId) {
    this.content = requestDto.getContent();
    this.cardId = cardId;
    this.userId = userId;
  }

  public void update(CommentRequestDto requestDto) {
    this.content = requestDto.getContent();
  }
}
