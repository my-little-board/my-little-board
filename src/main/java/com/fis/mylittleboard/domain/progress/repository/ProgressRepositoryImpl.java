package com.fis.mylittleboard.domain.progress.repository;

import com.fis.mylittleboard.domain.progress.entity.Progress;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProgressRepositoryImpl implements ProgressRepository{

	private final ProgressJpaRepository progressJpaRepository;

	@Override
	public void save(Progress progress) {
		progressJpaRepository.save(progress);
	}
}
