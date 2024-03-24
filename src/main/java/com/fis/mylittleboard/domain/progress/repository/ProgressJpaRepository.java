package com.fis.mylittleboard.domain.progress.repository;

import com.fis.mylittleboard.domain.progress.entity.Progress;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgressJpaRepository extends JpaRepository<Progress, Long> {

  Optional<Progress> findByPosition(Long position);

  List<Progress> findAllProgressesByBoardId(Long boardId);

  void deleteAllById (Long boardId);
}
