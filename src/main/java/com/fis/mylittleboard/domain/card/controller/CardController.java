package com.fis.mylittleboard.domain.card.controller;

import com.fis.mylittleboard.domain.card.dto.CardRequestDto;
import com.fis.mylittleboard.domain.card.dto.CardResponseDto;
import com.fis.mylittleboard.domain.card.service.CardService;
import com.fis.mylittleboard.global.common.ResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cards")
public class CardController {

	private final CardService cardService;

	@PostMapping
	public ResponseEntity<ResponseDto> createCard(@Valid @RequestBody CardRequestDto requestDto) {
		cardService.createCard(requestDto);

		return ResponseEntity.ok()
			.body(ResponseDto.builder()
				.message("카드 생성에 성공하였습니다.")
				.build());
	}

}
