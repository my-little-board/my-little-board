package com.fis.mylittleboard.domain.progress.repository;

import com.fis.mylittleboard.domain.progress.entity.Progress;
import com.fis.mylittleboard.domain.progress.entity.QProgress;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProgressRepositoryImpl implements ProgressRepository {

  private final ProgressJpaRepository progressJpaRepository;
  private final JPAQueryFactory jpaQueryFactory;

  @Override
  public Progress save(Progress progress) {
    return progressJpaRepository.save(progress);
  }

  @Override
  public Optional<Progress> findById(Long progressId) {
    return progressJpaRepository.findById(progressId);
  }

  @Override
  public void delete(Progress progress) {
    progressJpaRepository.delete(progress);
  }

  @Override
  public Long find() {
    return jpaQueryFactory.select(QProgress.progress.count())
        .from(QProgress.progress)
        .fetchFirst();
  }

  @Override
  public Optional<Progress> findByPosition(Long position) {
    return progressJpaRepository.findByPosition(position);
  }

  public List<Long> getProgressIds(Long boardId) {

    return jpaQueryFactory.select(QProgress.progress.id)
        .from(QProgress.progress)
        .where(QProgress.progress.boardId.eq(boardId))
        .orderBy(QProgress.progress.position.asc())
        .fetch();

  }

  @Override
  public List<Progress> findAllProgressesByBoardId(Long boardId) {
    return progressJpaRepository.findAllProgressesByBoardId(boardId);
  }

  @Override
  public void deleteAllProgress(Long boardId) {
    progressJpaRepository.deleteAllById(boardId);
  }
}
