package com.fis.mylittleboard.domain.card.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
public class CardRequestDto {

  @NotNull(message = "내용을 입력하세요.")
  private String name;


  private String description;

//	@NotNull(message = "색상을 입력하세요.")
//	private String color;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate dueDate;

  @NotNull
  private Long boardId;

  @NotNull
  private Long progressId;

//	private List<Long> members;
//
//	private List<Long> labels;

}
