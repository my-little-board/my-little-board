package com.fis.mylittleboard.domain.card.dto;

import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CardLabelReqDto {

	private List<Long> labelId;
}
