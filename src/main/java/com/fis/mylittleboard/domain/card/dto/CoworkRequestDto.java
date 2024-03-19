package com.fis.mylittleboard.domain.card.dto;

import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CoworkRequestDto {

	@NotNull(message = "작업자를 추가하세요.")
	private List<Long> workers;

}
