package com.fis.mylittleboard.domain.comment.controller;

import com.fis.mylittleboard.domain.comment.dto.CommentRequestDto;
import com.fis.mylittleboard.domain.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comments")
public class CommentController {

  private final CommentService commentService;

  @PostMapping
  public String createComment (
      @RequestBody CommentRequestDto requestDto) {
    commentService.createCommnet(requestDto);

    return "댓글이 생성되었습니다";
  }

  @PutMapping("/{commentId}")
  public String updateComment (
      @PathVariable Long commentId,
      @RequestBody CommentRequestDto requestDto) {
    commentService.updateComment(commentId, requestDto);

    return "댓글이 수정되었습니다.";
  }

  @DeleteMapping("/{commentId}")
  public String deleteComment (
      @PathVariable Long commentId) {
    commentService.deleteComment(commentId);

    return "댓글이 삭제되었습니다.";
  }
}
