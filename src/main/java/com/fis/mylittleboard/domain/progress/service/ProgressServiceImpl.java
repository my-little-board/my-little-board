package com.fis.mylittleboard.domain.progress.service;

import com.fis.mylittleboard.domain.progress.dto.ProgressRequestDto;
import com.fis.mylittleboard.domain.progress.entity.Progress;
import com.fis.mylittleboard.domain.progress.repository.ProgressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProgressServiceImpl implements ProgressService {

	private final ProgressRepository progressRepository;

	@Override
	public void createProgress(String classification) {
		Progress progress = new Progress(classification);

		progressRepository.save(progress);
	}

	@Override
	public void updateProgress(Long progressId, String classification) {

		Progress progress = progressRepository.findById(progressId)
			.orElseThrow(() -> new IllegalArgumentException("해당 분류는 존재하지 않습니다."));

		progress.updateProgress(classification);
	}
}
