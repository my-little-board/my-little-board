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

	private Progress getProgress(Long progressId) {
		return progressRepository.findById(progressId)
			.orElseThrow(() -> new IllegalArgumentException("해당 분류는 존재하지 않습니다."));
	}

	@Transactional
	public ProgressResDto createProgress(Long boardId, String classification) {
		Board board = boardRepository.findById(boardId)
			.orElseThrow(() -> new IllegalArgumentException("해당 보드는 존재하지 않습니다."));
		Long count = progressRepository.find();
		Progress progress = new Progress(classification, board.getId(), count + 1);

		return new ProgressResDto(progressRepository.save(progress));

	}

	@Transactional
	public void updateProgress(Long progressId, String classification) {

		Progress progress = getProgress(progressId);

		progress.updateProgress(classification);
	}

	@Transactional
	public void deleteProgress(Long progressId) {

		Progress progress = getProgress(progressId);

		List<Card> cards = cardRepository.findByProgressId(progressId);

		cards.forEach(cardRepository::delete);
		progressRepository.delete(progress);
	}

	@Transactional
	public void move(Long progressId, Long boardId, Long position) {
		Progress progress1 = getProgress(progressId);

		Progress progress2 = progressRepository.findByPosition(position)
			.orElseThrow(() -> new IllegalArgumentException("해당 위치의 분류는 존재하지 않습니다."));

		Board board = boardRepository.findById(boardId)
			.orElseThrow(() -> new IllegalArgumentException("해당 보드는 존재하지 않습니다."));

		Long progress1position = progress1.getPosition();
		Long progress2position = progress2.getPosition();

		progress1.movePosition(progress2position);
		progress2.movePosition(progress1position);
		progress1.moveBoard(board.getId());

	}
}
