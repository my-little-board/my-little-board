package com.fis.mylittleboard.domain.label.service;

import com.fis.mylittleboard.domain.label.dto.LabelResponseDto;

public interface LabelService {

	LabelResponseDto createLabel(String label, String color);

	void deleteLabel(Long labelId);

	LabelResponseDto updateLabel(Long labelId, String title, String color);
}
