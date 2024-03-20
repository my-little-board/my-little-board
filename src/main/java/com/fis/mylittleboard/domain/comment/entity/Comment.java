package com.fis.mylittleboard.domain.comment.entity;

import com.fis.mylittleboard.domain.comment.dto.CommentRequestDto;
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
public class Comment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String content;

  public Comment(CommentRequestDto requestDto) {
    this.content = requestDto.getContent();
  }

  public void update(CommentRequestDto requestDto) {
    this.content = requestDto.getContent();
  }
}
