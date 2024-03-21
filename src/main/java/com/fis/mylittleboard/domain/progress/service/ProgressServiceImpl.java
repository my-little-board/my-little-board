package com.fis.mylittleboard.domain.progress.service;

import com.fis.mylittleboard.domain.board.entity.Board;
import com.fis.mylittleboard.domain.board.repository.BoardRepository;
import com.fis.mylittleboard.domain.card.entity.Card;
import com.fis.mylittleboard.domain.card.repository.card.CardRepository;
import com.fis.mylittleboard.domain.progress.dto.ProgressResDto;
import com.fis.mylittleboard.domain.progress.entity.Progress;
import com.fis.mylittleboard.domain.progress.repository.ProgressRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProgressServiceImpl implements ProgressService {

	private final ProgressRepository progressRepository;
	private final CardRepository cardRepository;
	private final BoardRepository boardRepository;

	@Transactional
	public ProgressResDto createProgress(Long boardId, String classification) {
		Board board = boardRepository.findById(boardId)
			.orElseThrow(() -> new IllegalArgumentException("해당 보드는 존재하지 않습니다."));
		Long count = progressRepository.find();
		Progress progress = new Progress(classification, board.getId(), count+1);

		return new ProgressResDto(progressRepository.save(progress));

	}

	@Override
	public void updateProgress(Long progressId, String classification) {

		Progress progress = progressRepository.findById(progressId)
			.orElseThrow(() -> new IllegalArgumentException("해당 분류는 존재하지 않습니다."));

		progress.updateProgress(classification);
	}

	@Override
	public void deleteProgress(Long progressId) {

		Progress progress = progressRepository.findById(progressId)
			.orElseThrow(() -> new IllegalArgumentException("해당 분류는 존재하지 않습니다."));

		List<Card> cards = cardRepository.findByProgressId(progressId);

		cards.forEach(cardRepository::delete);
		progressRepository.delete(progress);
	}
}
