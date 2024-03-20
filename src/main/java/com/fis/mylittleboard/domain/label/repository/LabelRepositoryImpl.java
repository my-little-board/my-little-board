package com.fis.mylittleboard.domain.label.repository;

import com.fis.mylittleboard.domain.label.entity.Label;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class LabelRepositoryImpl implements LabelRepository{

	private final LabelJpaRepository labelJpaRepository;

	@Override
	public Label save(Label label) {
		return labelJpaRepository.save(label);
	}

	@Override
	public Optional<Label> findById(Long labelId) {
		return labelJpaRepository.findById(labelId);
	}

	@Override
	public void delete(Label label) {
		labelJpaRepository.delete(label);
	}
}
