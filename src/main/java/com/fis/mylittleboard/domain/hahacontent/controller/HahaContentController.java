package com.fis.mylittleboard.domain.hahacontent.controller;

import com.fis.mylittleboard.domain.hahacontent.dto.HahaContentRequestDto;
import com.fis.mylittleboard.domain.hahacontent.service.HahaContentService;
import com.fis.mylittleboard.domain.hahacontent.service.HahaContentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class HahaContentController {

  private final HahaContentService hahaContentService;

  @PostMapping("/hahaboards/{hahaboardId}")
  public String createHahaContent(
      @PathVariable Long hahaboardId,
      @RequestBody HahaContentRequestDto requestDto) {
    hahaContentService.createHahaContent(hahaboardId, requestDto);

    return "잡담글이 생성되었읍니다.";
  }

}
