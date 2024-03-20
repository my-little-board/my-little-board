package com.fis.mylittleboard.domain.card.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.Getter;

@Getter
public class MemberReqDto {

	@NotNull(message = "추가하고자 하는 member를 입력하세요")
	private String username;

}
