package com.fis.mylittleboard.domain.hahacontent.entity;

import com.fis.mylittleboard.domain.common.TimeStamp;
import com.fis.mylittleboard.domain.hahacontent.dto.HahaContentRequestDto;
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
import org.springframework.data.annotation.LastModifiedDate;

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

  public HahaContent(Long hahaboardId, HahaContentRequestDto requestDto) {
    this.content = requestDto.getContent();
    this.hahaboardId = hahaboardId;
  }
}
