package com.fis.mylittleboard.domain.comment.service;

import com.fis.mylittleboard.domain.comment.dto.CommentRequestDto;
import org.springframework.stereotype.Service;

public interface CommentService {

  void createCommnet(CommentRequestDto requestDto);

  void updateComment(Long commentId, CommentRequestDto requestDto);

  void deleteComment(Long commentId);

}
