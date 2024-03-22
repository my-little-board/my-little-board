package com.fis.mylittleboard.domain.hahacontent.entity;

import com.fis.mylittleboard.domain.hahacontent.dto.HahaContentRequestDto;
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
@Table(name = "hahacontents")
public class HahaContent extends TimeStamp {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String content;

  @Column
  private Long hahaboardId;

  @Column
  private Long userId;

  public HahaContent(Long hahaboardId, HahaContentRequestDto requestDto, Long userId) {
    this.content = requestDto.getContent();
    this.hahaboardId = hahaboardId;
    this.userId = userId;

  }
}
