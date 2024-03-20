package com.fis.mylittleboard.domain.hahacontent.service;

import com.fis.mylittleboard.domain.hahacontent.dto.HahaContentRequestDto;

public interface HahaContentService {

  void createHahaContent(Long hahaboardId, HahaContentRequestDto requestDto);

}
