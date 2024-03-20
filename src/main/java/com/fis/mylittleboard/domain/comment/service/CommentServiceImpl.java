package com.fis.mylittleboard.domain.comment.service;

import com.fis.mylittleboard.domain.comment.dto.CommentRequestDto;
import com.fis.mylittleboard.domain.comment.entity.Comment;
import com.fis.mylittleboard.domain.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

  private final CommentRepository commentRepository;

  @Override
  @Transactional
  public void createCommnet(CommentRequestDto requestDto) {
    Comment comment = new Comment(requestDto);

    commentRepository.save(comment);
  }

  @Override
  @Transactional
  public void updateComment(Long commentId, CommentRequestDto requestDto) {
    Comment comment = commentRepository.findById(commentId).orElseThrow(() ->
        new IllegalArgumentException("존재하지 않는 댓글입니다."));

    comment.update(requestDto);
  }

  @Override
  @Transactional
  public void deleteComment(Long commentId) {
    commentRepository.deleteById(commentId);
  }
}
