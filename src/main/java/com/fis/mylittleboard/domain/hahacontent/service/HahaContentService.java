package com.fis.mylittleboard.domain.hahacontent.service;

import com.fis.mylittleboard.domain.hahacontent.dto.HahaContentRequestDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface HahaContentService {

  void createHahaContent(Long hahaboardId, HahaContentRequestDto requestDto);

}
