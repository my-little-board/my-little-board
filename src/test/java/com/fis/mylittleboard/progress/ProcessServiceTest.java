package com.fis.mylittleboard.progress;

import com.fis.mylittleboard.domain.board.entity.Board;
import com.fis.mylittleboard.domain.board.repository.BoardRepository;
import com.fis.mylittleboard.domain.card.repository.card.CardRepository;
import com.fis.mylittleboard.domain.card.repository.date.DateRepository;
import com.fis.mylittleboard.domain.progress.entity.Progress;
import com.fis.mylittleboard.domain.progress.repository.ProgressRepository;
import com.fis.mylittleboard.domain.progress.service.ProgressServiceImpl;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.LongStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class ProcessServiceTest {


	@Autowired
	ProgressRepository progressRepository;
	@Autowired
	CardRepository cardRepository;
	@Autowired
	BoardRepository boardRepository;
	@Autowired
	DateRepository dateRepository;

	@Autowired
	ProgressServiceImpl progressService;

	void testProgress() {
		LongStream.range(0L, 5L)
			.forEach(i -> {
				Progress progress = new Progress();
				ProgressTestUtils.setProgress(progress, "Todo", 1L, i);
				progressRepository.save(progress);
			});

	}

	void testBoard() {
		Board board = new Board();
		ProgressTestUtils.setBoard(board, "workspaceA", "내용", "skyblue", 1L);
		boardRepository.save(board);
	}


}
