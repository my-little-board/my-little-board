package com.fis.mylittleboard.domain.label.controller;

import com.fis.mylittleboard.domain.label.dto.LabelRequestDto;
import com.fis.mylittleboard.domain.label.service.LabelService;
import com.fis.mylittleboard.global.common.MessageResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/labels")
public class LabelController {

	private final LabelService labelService;

	@Transactional
	@PostMapping
	public ResponseEntity<MessageResponseDto> createLabel(
		@Valid @RequestBody LabelRequestDto labelRequestDto) {
		labelService.createLabel(labelRequestDto.getLabel());

		return ResponseEntity.ok()
			.body(MessageResponseDto.builder()
				.message("라벨 생성에 성공하였습니다.")
				.build());
	}

	@Transactional
	@DeleteMapping("{labelId}")
	public ResponseEntity<MessageResponseDto> deleteLabel(@PathVariable Long labelId) {
		labelService.deleteLabel(labelId);

		return ResponseEntity.ok()
			.body(MessageResponseDto.builder()
				.message("라벨 삭제에 성공하였습니다.")
				.build());
	}


}
