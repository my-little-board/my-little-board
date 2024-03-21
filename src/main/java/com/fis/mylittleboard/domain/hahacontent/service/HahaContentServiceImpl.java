package com.fis.mylittleboard.domain.hahacontent.service;

import com.fis.mylittleboard.domain.hahacontent.dto.HahaContentRequestDto;
import com.fis.mylittleboard.domain.hahacontent.entity.HahaContent;
import com.fis.mylittleboard.domain.hahacontent.repository.HahaContentRepository;
import com.fis.mylittleboard.global.jwt.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HahaContentServiceImpl implements HahaContentService {

  private final HahaContentRepository hahaContentRepository;

  public void createHahaContent(Long hahaboardId, HahaContentRequestDto requestDto,
      UserDetailsImpl details) {
    HahaContent content = new HahaContent(hahaboardId, requestDto, details.getUser().getId());

    hahaContentRepository.save(content);
  }
}
