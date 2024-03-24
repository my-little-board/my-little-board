package com.fis.mylittleboard.domain.progress.service;

import com.fis.mylittleboard.domain.board.entity.Board;
import com.fis.mylittleboard.domain.board.repository.BoardRepository;
import com.fis.mylittleboard.domain.card.dto.CardResponseDto;
import com.fis.mylittleboard.domain.card.entity.Card;
import com.fis.mylittleboard.domain.card.entity.Date;
import com.fis.mylittleboard.domain.card.repository.card.CardRepository;
import com.fis.mylittleboard.domain.card.repository.date.DateRepository;
import com.fis.mylittleboard.domain.progress.dto.ProgressAllList;
import com.fis.mylittleboard.domain.progress.dto.ProgressListResDto;
import com.fis.mylittleboard.domain.progress.dto.ProgressResDto;
import com.fis.mylittleboard.domain.progress.entity.Progress;
import com.fis.mylittleboard.domain.progress.repository.ProgressJpaRepository;
import com.fis.mylittleboard.domain.progress.repository.ProgressRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProgressServiceImpl implements ProgressService {

	private final ProgressRepository progressRepository;
	private final CardRepository cardRepository;
	private final BoardRepository boardRepository;
	private final DateRepository dateRepository;
	private final RedissonClient redissonClient;

	private static final String LOCK_KEY = "progressLock";

  public Progress getProgress(Long progressId) {
    return progressRepository.findById(progressId)
        .orElseThrow(() -> new IllegalArgumentException("해당 분류는 존재하지 않습니다."));
  }

	@Transactional
	public ProgressResDto createProgress(Long boardId, String classification) {
		Board board = boardRepository.findById(boardId);
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

	public void move(Long progressId, Long boardId, Long position) {
		RLock lock = redissonClient.getFairLock(LOCK_KEY);

		try{
			boolean isLocked = lock.tryLock(10, 60, TimeUnit.SECONDS);
			if(isLocked) {
				try{
					Progress progress1 = getProgress(progressId);

					Progress progress2 = progressRepository.findByPosition(position)
						.orElseThrow(() -> new IllegalArgumentException("해당 위치의 분류는 존재하지 않습니다."));

					Board board = boardRepository.findById(boardId);

					Long progress1position = progress1.getPosition();
					Long progress2position = progress2.getPosition();

					progress1.movePosition(progress2position);
					progress2.movePosition(progress1position);
					progress1.moveBoard(board.getId());
					progressRepository.save(progress1);
					progressRepository.save(progress2);
				} finally {
					lock.unlock();
				}
			}
		}catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
  }

  @Transactional(readOnly = true)
  public ProgressAllList getProgresses(Long boardId) {

    List<ProgressListResDto> progressListResDtos = progressRepository.getProgressIds(boardId)
        .stream()
        .map(progressId -> {
          Progress progress = getProgress(progressId);
          List<CardResponseDto> cardResDtos = cardRepository.findByProgressId(
                  progress.getId()).stream()
              .map(card -> {
                List<Long> members = cardRepository.getMemberIds(card.getId());
                List<Long> labels = cardRepository.getLabelIds(card.getId());
                Optional<Date> dateEntityOptional = dateRepository.findByCardId(
                    card.getId());
                LocalDate dueDate =
                    dateEntityOptional.map(Date::getDueDate).orElse(null);
                return new CardResponseDto(card, members, labels, dueDate);
              })
              .toList();
          return new ProgressListResDto(progress.getClassification(), cardResDtos);
        })
        .toList();

    return new ProgressAllList(progressListResDtos);
  }
}
