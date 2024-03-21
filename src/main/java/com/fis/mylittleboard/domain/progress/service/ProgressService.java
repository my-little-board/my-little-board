package com.fis.mylittleboard.domain.progress.service;

import com.fis.mylittleboard.domain.progress.dto.ProgressResDto;

public interface ProgressService {

  ProgressResDto createProgress(Long boardId, String classification);

  void updateProgress(Long progressId, String classification);

  void deleteProgress(Long progressId);

  void move(Long progressId, Long boardId, Long position);
}
