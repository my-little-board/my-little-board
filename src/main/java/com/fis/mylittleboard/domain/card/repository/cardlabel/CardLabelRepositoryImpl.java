package com.fis.mylittleboard.domain.card.repository.cardlabel;

import com.fis.mylittleboard.domain.card.entity.CardLabel;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CardLabelRepositoryImpl implements CardLabelRepository {

  private final CardLabelJpaRepository cardLabelJpaRepository;

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
}
