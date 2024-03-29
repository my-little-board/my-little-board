package com.fis.mylittleboard.domain.progress.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "progresses")
public class Progress {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String classification;

  @Column(nullable = false)
  private Long boardId;

  @Column(nullable = false)
  private Long position;

  @Builder
  public Progress(String classification, Long boardId, Long position) {
    this.classification = classification;
    this.boardId = boardId;
    this.position = position;
  }

  public void updateProgress(String newClassification) {
    this.classification = newClassification;
  }

  public void movePosition(Long position) {
    this.position = position;
  }

  public void moveBoard(Long boardId) {
    this.boardId = boardId;
  }
}
