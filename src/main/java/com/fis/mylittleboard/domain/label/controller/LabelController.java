package com.fis.mylittleboard.domain.label.controller;

import com.fis.mylittleboard.domain.label.dto.LabelRequestDto;
import com.fis.mylittleboard.domain.label.dto.LabelResponseDto;
import com.fis.mylittleboard.domain.label.service.LabelService;
import com.fis.mylittleboard.global.common.MessageResponseDto;
import com.fis.mylittleboard.global.common.ResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/labels")
public class LabelController {

  private final LabelService labelService;

  @PostMapping
  public ResponseEntity<ResponseDto<LabelResponseDto>> createLabel(
      @Valid @RequestBody LabelRequestDto labelRequestDto) {
    LabelResponseDto labelResponseDto = labelService.createLabel(labelRequestDto.getTitle(),
        labelRequestDto.getColor());

    return ResponseEntity.ok()
        .body(ResponseDto.<LabelResponseDto>builder()
            .message("라벨 생성에 성공하였습니다.")
            .data(labelResponseDto)
            .build());
  }

  @PutMapping("/{labelId}")
  public ResponseEntity<ResponseDto<LabelResponseDto>> updateLabel(
      @Valid @RequestBody LabelRequestDto labelRequestDto, @PathVariable Long labelId) {
    LabelResponseDto labelResponseDto = labelService.updateLabel(labelId,
        labelRequestDto.getTitle(),
        labelRequestDto.getColor());

    return ResponseEntity.ok()
        .body(ResponseDto.<LabelResponseDto>builder()
            .message("라벨 수정에 성공하였습니다.")
            .data(labelResponseDto)
            .build());
  }

  @DeleteMapping("{labelId}")
  public ResponseEntity<MessageResponseDto> deleteLabel(@PathVariable Long labelId) {
    labelService.deleteLabel(labelId);

    return ResponseEntity.ok()
        .body(MessageResponseDto.builder()
            .message("라벨 삭제에 성공하였습니다.")
            .build());
  }


}
