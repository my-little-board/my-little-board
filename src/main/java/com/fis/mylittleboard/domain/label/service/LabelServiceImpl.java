package com.fis.mylittleboard.domain.label.service;

import com.fis.mylittleboard.domain.label.dto.LabelResponseDto;
import com.fis.mylittleboard.domain.label.entity.Label;
import com.fis.mylittleboard.domain.label.repository.LabelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LabelServiceImpl implements LabelService {

  private final LabelRepository labelRepository;

  @Transactional
  @Override
  public LabelResponseDto createLabel(String title, String color) {
    Label label = new Label(title, color);

    Label savedLabel = labelRepository.save(label);
    return new LabelResponseDto(savedLabel);
  }


  @Transactional
  @Override
  public void deleteLabel(Long labelId) {
    Label label = labelRepository.findById(labelId)
        .orElseThrow(() -> new IllegalArgumentException("해당 라벨은 존재하지 않습니다."));

    labelRepository.delete(label);
  }

  @Transactional
  @Override
  public LabelResponseDto updateLabel(Long labelId, String title, String color) {
    Label label = labelRepository.findById(labelId)
        .orElseThrow(() -> new IllegalArgumentException("해당 라벨은 존재하지 않습니다."));
    label.updateLabel(title, color);

    return new LabelResponseDto(label);
  }
}
