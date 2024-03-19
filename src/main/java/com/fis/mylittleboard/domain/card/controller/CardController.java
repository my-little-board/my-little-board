package com.fis.mylittleboard.domain.card.controller;

import com.fis.mylittleboard.domain.card.dto.CardRequestDto;
import com.fis.mylittleboard.domain.card.dto.CardResponseDto;
import com.fis.mylittleboard.domain.card.service.CardService;
import com.fis.mylittleboard.global.common.MessageResponseDto;
import com.fis.mylittleboard.global.common.ResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cards")
public class CardController {

	private final CardService cardService;

	//boardId와 progressId 검증
	@Transactional
	@PostMapping
	public ResponseEntity<MessageResponseDto> createCard(@Valid @RequestBody CardRequestDto requestDto) {
		cardService.createCard(requestDto);

		return ResponseEntity.ok()
			.body(MessageResponseDto.builder()
				.message("카드 생성에 성공하였습니다.")
				.build());
	}

	@Transactional
	@PutMapping("/{cardId}")
	public ResponseEntity<MessageResponseDto> updateCard(@PathVariable Long cardId,
		@Valid @RequestBody CardRequestDto cardRequestDto) {
		cardService.updateCard(cardId, cardRequestDto);

		return ResponseEntity.ok()
			.body(MessageResponseDto.builder()
				.message("카드 수정에 성공하였습니다.")
				.build());
	}

	@Transactional
	@DeleteMapping("/{cardId}")
	public ResponseEntity<MessageResponseDto> deleteCard(@PathVariable Long cardId) {
		cardService.deleteCard(cardId);

		return ResponseEntity.ok()
			.body(MessageResponseDto.builder()
				.message("카드 삭제에 성공하였습니다.")
				.build());
	}

	@GetMapping("/{cardId}")
	public ResponseEntity<ResponseDto<CardResponseDto>> getCard(@PathVariable Long cardId) {
		CardResponseDto cardResponseDto = cardService.getCard(cardId);

		return ResponseEntity.ok()
			.body(ResponseDto.<CardResponseDto>builder()
				.message("카드 조회에 성공하였습니다.")
				.data(cardResponseDto)
				.build());
	}
}
