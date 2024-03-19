package com.fis.mylittleboard.domain.progress.controller;

import com.fis.mylittleboard.domain.progress.dto.ProgressRequestDto;
import com.fis.mylittleboard.domain.progress.service.ProgressService;
import com.fis.mylittleboard.global.common.MessageResponseDto;
import com.fis.mylittleboard.global.common.ResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/progresses")
public class ProgressController {

	private final ProgressService progressService;

	@Transactional
	@PostMapping
	public ResponseEntity<MessageResponseDto> createProgress(
		@Valid @RequestBody ProgressRequestDto progressRequestDto) {

		progressService.createProgress(progressRequestDto.getClassification());

		return ResponseEntity.ok()
			.body(MessageResponseDto.builder()
				.message("분류 생성에 성공하였습니다.")
				.build());
	}

	@Transactional
	@PutMapping("/{progressId}")
	public ResponseEntity<MessageResponseDto> updateProgress(@PathVariable Long progressId,
		@Valid @RequestBody ProgressRequestDto progressRequestDto) {

		progressService.updateProgress(progressId, progressRequestDto.getClassification());

		return ResponseEntity.ok()
			.body(MessageResponseDto.builder()
				.message("분류 수정에 성공하였습니다.")
				.build());

	}

	@Transactional
	@DeleteMapping("/{progressId}")
	public ResponseEntity<MessageResponseDto> deleteProgress(@PathVariable Long progressId) {
		progressService.deleteProgress(progressId);

		return ResponseEntity.ok()
			.body(MessageResponseDto.builder()
				.message("분류 수정에 성공하였습니다.")
				.build());
	}

}
