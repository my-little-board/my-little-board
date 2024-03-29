package com.fis.mylittleboard.domain.card.repository.card;

import static com.fis.mylittleboard.domain.card.entity.QCardLabel.cardLabel;
import static com.fis.mylittleboard.domain.card.entity.QMember.member;

import com.fis.mylittleboard.domain.card.entity.Card;
import com.fis.mylittleboard.domain.card.entity.QCard;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CardRepositoryImpl implements CardRepository {

  private final CardJpaRepository cardJpaRepository;
  private final JPAQueryFactory jpaQueryFactory;

  @Override
  public Card save(Card card) {
    cardJpaRepository.save(card);
    return card;
  }

  @Override
  public Optional<Card> findById(Long cardId) {
    return cardJpaRepository.findById(cardId);
  }

  @Override
  public void delete(Card card) {
    cardJpaRepository.delete(card);
  }

  @Override
  public List<Long> getMemberIds(Long cardId) {
    return jpaQueryFactory.select(member.cardId)
        .from(member)
        .where(member.cardId.eq(cardId))
        .fetch();


  }

  @Override
  public List<Long> getLabelIds(Long cardId) {
    return jpaQueryFactory.select(cardLabel.labelId)
        .from(cardLabel)
        .where(cardLabel.cardId.eq(cardId))
        .fetch();
  }

  @Override
  public List<Card> findByProgressId(Long progressId) {
    return cardJpaRepository.findByProgressId(progressId);
  }

  @Override
  public List<Card> getCardByboard(Long boardId, Long cardId) {
    return jpaQueryFactory.selectFrom(QCard.card)
        .where(QCard.card.boardId.eq(boardId), QCard.card.id.eq(cardId))
        .fetch();
  }

  @Override
  public void deleteAllCard(Long boardId) {
    cardJpaRepository.deleteAllById(boardId);
  }

  @Override
  public List<Card> findAllCard(Long progressId) {
    return cardJpaRepository.findByProgressId(progressId);
  }
}
