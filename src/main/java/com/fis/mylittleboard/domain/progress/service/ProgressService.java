package com.fis.mylittleboard.domain.progress.service;

public interface ProgressService {

  void createProgress(String classification);

  void updateProgress(Long progressId, String classification);

  void deleteProgress(Long progressId);
}
