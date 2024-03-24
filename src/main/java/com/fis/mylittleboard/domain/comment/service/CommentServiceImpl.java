package com.fis.mylittleboard.domain.comment.service;

import com.fis.mylittleboard.domain.card.entity.Card;
import com.fis.mylittleboard.domain.card.repository.card.CardRepository;
import com.fis.mylittleboard.domain.comment.dto.CommentRequestDto;
import com.fis.mylittleboard.domain.comment.entity.Comment;
import com.fis.mylittleboard.domain.comment.repository.CommentRepository;
import com.fis.mylittleboard.global.jwt.security.UserDetailsImpl;
import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

  private final CommentRepository commentRepository;
  private final CardRepository cardRepository;

  @Override
  @Transactional
  public void createComment(
      CommentRequestDto requestDto, Long cardId, UserDetailsImpl userDetails) {
    Optional<Card> card = cardRepository.findById(cardId);
    if (card.isPresent()) {
      Comment comment = new Comment(requestDto, card.get().getId(), userDetails.getUser().getId());
      commentRepository.save(comment);
    }
  }

  @Override
  @Transactional
  public void updateComment(
      Long commentId, CommentRequestDto requestDto, UserDetailsImpl userDetails) {
    Comment comment = findComment(commentId);
    if (!Objects.equals(comment.getUserId(), userDetails.getUser().getId())) {
      throw new IllegalArgumentException("댓글 작성자만 수정할 수 있습니다.");
    }
    comment.update(requestDto);
  }

  @Override
  @Transactional
  public void deleteComment(Long commentId, UserDetailsImpl userDetails) {
    Comment comment = findComment(commentId);
    if (!Objects.equals(comment.getUserId(), userDetails.getUser().getId())) {
      throw new IllegalArgumentException("작성자만 삭제할 수 있습니다.");
    }
    commentRepository.deleteById(commentId);
  }

  private Comment findComment(Long commentId) {
    return commentRepository.findById(commentId).orElseThrow(() ->
        new IllegalArgumentException("댓글이 존재하지 않습니다."));
  }
}
