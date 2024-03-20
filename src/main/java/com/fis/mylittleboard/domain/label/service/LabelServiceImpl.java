package com.fis.mylittleboard.domain.label.service;

import com.fis.mylittleboard.domain.label.entity.Label;
import com.fis.mylittleboard.domain.label.repository.LabelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LabelServiceImpl implements LabelService {

	private final LabelRepository labelRepository;

	@Override
	public void createLabel(String labelname) {
		Label label = new Label(labelname);

		labelRepository.save(label);
	}

	@Override
	public void deleteLabel(Long labelId) {
		Label label = labelRepository.findById(labelId)
			.orElseThrow(() -> new IllegalArgumentException("해당 라벨은 존재하지 않습니다."));

		labelRepository.delete(label);
	}
}
