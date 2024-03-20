package com.fis.mylittleboard.domain.card.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
public class CardDatesRequestDto {

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dueDate;

}
