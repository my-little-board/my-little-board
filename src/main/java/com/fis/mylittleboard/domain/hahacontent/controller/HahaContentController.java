package com.fis.mylittleboard.domain.hahacontent.controller;

import com.fis.mylittleboard.domain.board.dto.BoardResponseDto;
import com.fis.mylittleboard.domain.hahacontent.dto.HahaContentRequestDto;
import com.fis.mylittleboard.domain.hahacontent.service.HahaContentService;
import com.fis.mylittleboard.global.common.MessageResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
  public ResponseEntity<MessageResponseDto> createHahaContent(
      @PathVariable Long hahaboardId,
      @RequestBody HahaContentRequestDto requestDto) {
    hahaContentService.createHahaContent(hahaboardId, requestDto);

    return ResponseEntity.ok()
        .body(MessageResponseDto.builder()
            .message("하하 워크스페이스의 잡담글이 생성되었습니다.")
            .build());
  }

}
