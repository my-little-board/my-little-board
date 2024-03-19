package com.fis.mylittleboard.domain.comment.service;

import com.fis.mylittleboard.domain.comment.dto.CommentRequestDto;
import com.fis.mylittleboard.domain.comment.entity.Comment;
import com.fis.mylittleboard.domain.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

  private final CommentRepository commentRepository;

  public void createCommnet(CommentRequestDto requestDto) {
    Comment comment = new Comment(requestDto);

    commentRepository.save(comment);
  }
}
