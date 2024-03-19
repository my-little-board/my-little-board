package com.fis.mylittleboard.domain.comment.controller;

import com.fis.mylittleboard.domain.comment.dto.CommentRequestDto;
import com.fis.mylittleboard.domain.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/comments")
public class CommentController {

  private final CommentService commentService;

  @PostMapping
  public String createComment (
      @RequestBody CommentRequestDto requestDto) {
    commentService.createCommnet(requestDto);

    return "댓글이 생성되었습니다";
  }
}
