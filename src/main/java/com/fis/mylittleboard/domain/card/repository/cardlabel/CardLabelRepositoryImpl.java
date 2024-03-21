package com.fis.mylittleboard.domain.card.repository.cardlabel;

import static com.fis.mylittleboard.domain.card.entity.QCardLabel.cardLabel;

import com.fis.mylittleboard.domain.card.entity.CardLabel;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CardLabelRepositoryImpl implements CardLabelRepository {

  private final CardLabelJpaRepository cardLabelJpaRepository;
  private final JPAQueryFactory jpaQueryFactory;

  @Override
  public void save(CardLabel cardLabel) {
    cardLabelJpaRepository.save(cardLabel);
  }

  @Override
  public Optional<CardLabel> findById(Long id) {
    return cardLabelJpaRepository.findById(id);
  }

  @Override
  public void delete(CardLabel cardLabel) {
    cardLabelJpaRepository.delete(cardLabel);
  }

  @Override
  public List<Long> findByLabelId(Long l) {
    return jpaQueryFactory.selectDistinct(cardLabel.cardId)
        .from(cardLabel)
        .where(cardLabel.labelId.eq(l))
        .fetch();
  }
}
