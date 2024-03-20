package com.fis.mylittleboard.domain.comment.service;

import com.fis.mylittleboard.domain.card.entity.Card;
import com.fis.mylittleboard.domain.card.repository.card.CardRepository;
import com.fis.mylittleboard.domain.comment.dto.CommentRequestDto;
import com.fis.mylittleboard.domain.comment.entity.Comment;
import com.fis.mylittleboard.domain.comment.repository.CommentRepository;
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
  public void createCommnet(CommentRequestDto requestDto, Long cardId) {
    Optional<Card> card = cardRepository.findById(cardId);
    if (card.isPresent()) {
      Comment comment = new Comment(requestDto, card.get().getId());
      commentRepository.save(comment);
    }
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
