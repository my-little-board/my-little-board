package com.fis.mylittleboard.domain.label.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "labels")
public class Label {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;


  @Column
  private String title;

  @Column(nullable = false)
  private String color;

  @Column(nullable = false)
  private Long boardId;

  @Builder
  public Label(Long boardId, String title, String color) {
    this.boardId = boardId;
    this.title = title;
    this.color = color;
  }

  public void updateLabel(String title, String color) {
    this.title = title;
    this.color = color;
  }

}
