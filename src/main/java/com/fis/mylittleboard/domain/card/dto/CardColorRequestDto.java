package com.fis.mylittleboard.domain.card.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;


@Getter
public class CardColorRequestDto {

	@NotNull
	private String color;

}
