package com.fis.mylittleboard.domain.progress.service;

import com.fis.mylittleboard.domain.progress.dto.ProgressRequestDto;
import com.fis.mylittleboard.domain.progress.entity.Progress;
import com.fis.mylittleboard.domain.progress.repository.ProgressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProgressServiceImpl implements ProgressService{

	private final ProgressRepository progressRepository;

	@Override
	public void createProgress(String classification) {
		Progress progress = new Progress(classification);

		progressRepository.save(progress);
	}
}
