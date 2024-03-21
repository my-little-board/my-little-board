package com.fis.mylittleboard.domain.progress.repository;

import com.fis.mylittleboard.domain.progress.entity.Progress;
import java.util.Optional;

public interface ProgressRepository {

  Progress save(Progress progress);

  Optional<Progress> findById(Long progressId);

  void delete(Progress progress);

  Long find();

  Optional<Progress> findByPosition(Long position);
}
