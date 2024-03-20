package com.fis.mylittleboard.domain.hahacontent.service;

import com.fis.mylittleboard.domain.board.entity.Board;
import com.fis.mylittleboard.domain.hahacontent.dto.HahaContentRequestDto;
import com.fis.mylittleboard.domain.hahacontent.entity.HahaContent;
import com.fis.mylittleboard.domain.hahacontent.repository.HahaContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HahaContentService {

  private final HahaContentRepository hahaContentRepository;

  public void createHahaContent(Long hahaboardId, HahaContentRequestDto requestDto) {
    HahaContent content = new HahaContent(hahaboardId, requestDto);

    hahaContentRepository.save(content);
  }
}
