package com.fis.mylittleboard.domain.progress.repository;

import com.fis.mylittleboard.domain.progress.entity.Progress;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProgressRepositoryImpl implements ProgressRepository {

  private final ProgressJpaRepository progressJpaRepository;

  @Override
  public void save(Progress progress) {
    progressJpaRepository.save(progress);
  }

  @Override
  public Optional<Progress> findById(Long progressId) {
    return progressJpaRepository.findById(progressId);
  }

  @Override
  public void delete(Progress progress) {
    progressJpaRepository.delete(progress);
  }
}
