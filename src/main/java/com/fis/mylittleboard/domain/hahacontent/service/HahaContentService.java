package com.fis.mylittleboard.domain.hahacontent.service;

import com.fis.mylittleboard.domain.hahacontent.dto.HahaContentRequestDto;
import com.fis.mylittleboard.global.jwt.security.UserDetailsImpl;

public interface HahaContentService {

  void createHahaContent(Long hahaboardId, HahaContentRequestDto requestDto,
      UserDetailsImpl details);

}
