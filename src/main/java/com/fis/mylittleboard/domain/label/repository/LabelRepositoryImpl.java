package com.fis.mylittleboard.domain.label.repository;

import com.fis.mylittleboard.domain.label.entity.Label;
import com.fis.mylittleboard.domain.label.entity.QLabel;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class LabelRepositoryImpl implements LabelRepository {

  private final LabelJpaRepository labelJpaRepository;
  private final JPAQueryFactory jpaQueryFactory;

  @Override
  public Label save(Label label) {
    return labelJpaRepository.save(label);
  }

  @Override
  public Optional<Label> findById(Long labelId) {
    return labelJpaRepository.findById(labelId);
  }

  @Override
  public void delete(Label label) {
    labelJpaRepository.delete(label);
  }

  @Override
  public List<Long> findByIds(Long boardId, Long l) {
    return jpaQueryFactory.select(QLabel.label.id)
        .from(QLabel.label)
        .where(QLabel.label.boardId.eq(boardId), QLabel.label.id.eq(l))
        .fetch();
  }
}
