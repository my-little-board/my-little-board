package com.fis.mylittleboard.domain.progress.repository;

import com.fis.mylittleboard.domain.progress.entity.Progress;
import java.util.Optional;

public interface ProgressRepository {

	void save(Progress progress);

	Optional<Progress> findById(Long progressId);

	void delete(Progress progress);

}
