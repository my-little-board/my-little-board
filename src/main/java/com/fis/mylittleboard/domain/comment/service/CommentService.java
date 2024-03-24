package com.fis.mylittleboard.domain.comment.service;

import com.fis.mylittleboard.domain.comment.dto.CommentRequestDto;
import com.fis.mylittleboard.global.jwt.security.UserDetailsImpl;

public interface CommentService {

  void createComment(CommentRequestDto requestDto, Long cardId, UserDetailsImpl userDetails);

  void updateComment(Long commentId, CommentRequestDto requestDto, UserDetailsImpl userDetails);

  void deleteComment(Long commentId, UserDetailsImpl userDetails);

}
