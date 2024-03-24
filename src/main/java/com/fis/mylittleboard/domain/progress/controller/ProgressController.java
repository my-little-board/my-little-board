package com.fis.mylittleboard.domain.progress.controller;

import com.fis.mylittleboard.domain.progress.dto.ProgressAllList;
import com.fis.mylittleboard.domain.progress.dto.ProgressMoveDto;
import com.fis.mylittleboard.domain.progress.dto.ProgressRequestDto;
import com.fis.mylittleboard.domain.progress.service.ProgressService;
import com.fis.mylittleboard.global.common.MessageResponseDto;
import com.fis.mylittleboard.global.common.ResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProgressController {

  private final ProgressService progressService;


  @PostMapping("/api/boards/{boardId}/progresses")
  public ResponseEntity<MessageResponseDto> createProgress(
      @PathVariable Long boardId,
      @Valid @RequestBody ProgressRequestDto progressRequestDto) {

    progressService.createProgress(boardId, progressRequestDto.getClassification());

    return ResponseEntity.ok()
        .body(MessageResponseDto.builder()
            .message("분류 생성에 성공하였습니다.")
            .build());
  }

  @PutMapping("/api/progresses/{progressId}")
  public ResponseEntity<MessageResponseDto> updateProgress(
      @PathVariable Long progressId,
      @Valid @RequestBody ProgressRequestDto progressRequestDto) {

    progressService.updateProgress(progressId, progressRequestDto.getClassification());

    return ResponseEntity.ok()
        .body(MessageResponseDto.builder()
            .message("분류 수정에 성공하였습니다.")
            .build());

  }


  @PostMapping("api/progresses/{progressId}")
  public ResponseEntity<ResponseDto<ProgressAllList>> move(
      @PathVariable Long progressId, @RequestBody
  ProgressMoveDto progressMoveDto) {

    progressService.move(progressId, progressMoveDto.getBoardId(),
        progressMoveDto.getPosition());

    ProgressAllList progressAllList = progressService.getProgresses(progressMoveDto.getBoardId());

    return ResponseEntity.ok()
        .body(ResponseDto.<ProgressAllList>builder()
            .message("move 성공하였습니다.")
            .data(progressAllList)
            .build());

  }

  @DeleteMapping("/api/progresses/{progressId}")
  public ResponseEntity<MessageResponseDto> deleteProgress(@PathVariable Long progressId) {
    progressService.deleteProgress(progressId);

    return ResponseEntity.ok()
        .body(MessageResponseDto.builder()
            .message("분류 삭제에 성공하였습니다.")
            .build());
  }

  @GetMapping("/api/boards/{boardId}/progresses")
  public ResponseEntity<ResponseDto<ProgressAllList>> getProgresses(
      @PathVariable Long boardId) {
    ProgressAllList progressListResDto = progressService.getProgresses(boardId);

    return ResponseEntity.ok()
        .body(ResponseDto.<ProgressAllList>builder()
            .message("조회 성공하였습니다.")
            .data(progressListResDto)
            .build());
  }

}
