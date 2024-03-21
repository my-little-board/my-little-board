package com.fis.mylittleboard.domain.label.service;

import com.fis.mylittleboard.domain.board.entity.Board;
import com.fis.mylittleboard.domain.board.repository.BoardRepository;
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
	private final BoardRepository boardRepository;

	@Transactional
	@Override
	public LabelResponseDto createLabel(Long boardId, String title, String color) {
		Board board = boardRepository.findById(boardId)
			.orElseThrow(() -> new IllegalArgumentException("해당 보드가 존재하지 않습니다."));

		Label label = new Label(board.getId(), title, color);

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
