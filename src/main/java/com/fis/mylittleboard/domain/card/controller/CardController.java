package com.fis.mylittleboard.domain.card.controller;

import com.fis.mylittleboard.domain.card.dto.CardColorRequestDto;
import com.fis.mylittleboard.domain.card.dto.CardColorResponseDto;
import com.fis.mylittleboard.domain.card.dto.CardDescriptionDto;
import com.fis.mylittleboard.domain.card.dto.CardDescriptionResponseDto;
import com.fis.mylittleboard.domain.card.dto.CardNameRequestDto;
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
import org.springframework.web.bind.annotation.PatchMapping;
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
	public ResponseEntity<MessageResponseDto> createCard(
		@Valid @RequestBody CardNameRequestDto cardNameRequestDto) {
		cardService.createCard(cardNameRequestDto);

		return ResponseEntity.ok()
			.body(MessageResponseDto.builder()
				.message("카드 생성에 성공하였습니다.")
				.build());
	}

	@Transactional
	@PatchMapping("/{cardId}/descriptions")
	public ResponseEntity<ResponseDto<CardDescriptionResponseDto>> updateDescription(
		@PathVariable Long cardId, @RequestBody CardDescriptionDto cardDescriptionDto) {
		String description = cardDescriptionDto.getDescription();

		CardDescriptionResponseDto cardDescriptionResponseDto = cardService.updateDescription(
			cardId, description);

		return ResponseEntity.ok()
			.body(ResponseDto.<CardDescriptionResponseDto>builder()
				.message("description 수정에 성공하였습니다.")
				.data(cardDescriptionResponseDto)
				.build());
	}

	@Transactional
	@PatchMapping("/{cardId}/colors")
	public ResponseEntity<ResponseDto<CardColorResponseDto>> updateColor(
		@PathVariable Long cardId, @RequestBody CardColorRequestDto cardColorRequestDto) {
		CardColorResponseDto cardColorResponseDto = cardService.updateColor(cardId,
			cardColorRequestDto.getColor());

		return ResponseEntity.ok()
			.body(ResponseDto.<CardColorResponseDto>builder()
				.message("color 수정에 성공하였습니다.")
				.data(cardColorResponseDto)
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
