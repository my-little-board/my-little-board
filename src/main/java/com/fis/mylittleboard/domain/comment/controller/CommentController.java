package com.fis.mylittleboard.domain.comment.controller;

import com.fis.mylittleboard.domain.comment.dto.CommentRequestDto;
import com.fis.mylittleboard.domain.comment.service.CommentService;
import com.fis.mylittleboard.global.common.MessageResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cards")
public class CommentController {

  private final CommentService commentService;

  @PostMapping("/{cardId}/comments")
  public ResponseEntity<MessageResponseDto> createComment(
      @RequestBody CommentRequestDto requestDto,
      @PathVariable Long cardId) {
    commentService.createCommnet(requestDto, cardId);

    return ResponseEntity.ok()
        .body(MessageResponseDto.builder()
            .message("댓글이 생성되었습니다.")
            .build());
  }

  @PutMapping("/comments/{commentId}")
  public ResponseEntity<MessageResponseDto> updateComment(
      @PathVariable Long commentId,
      @RequestBody CommentRequestDto requestDto) {
    commentService.updateComment(commentId, requestDto);

    return ResponseEntity.ok()
        .body(MessageResponseDto.builder()
            .message("댓글이 수정되었습니다.")
            .build());
  }

  @DeleteMapping("/comments/{commentId}")
  public ResponseEntity<MessageResponseDto> deleteComment(
      @PathVariable Long commentId) {
    commentService.deleteComment(commentId);

    return ResponseEntity.ok()
        .body(MessageResponseDto.builder()
            .message("댓글이 삭제되었습니다.")
            .build());
  }
}
