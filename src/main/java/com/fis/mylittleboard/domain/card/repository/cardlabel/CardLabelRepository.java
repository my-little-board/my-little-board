package com.fis.mylittleboard.domain.card.repository.cardlabel;

import com.fis.mylittleboard.domain.card.entity.CardLabel;
import java.util.List;
import java.util.Optional;

public interface CardLabelRepository {

  void save(CardLabel cardLabel);

  Optional<CardLabel> findById(Long id);

  void delete(CardLabel cardLabel);

  List<Long> findByLabelId(Long l);
}
