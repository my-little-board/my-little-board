package com.fis.mylittleboard.progress;

import com.fis.mylittleboard.CommonTest;
import com.fis.mylittleboard.TestUtils;
import com.fis.mylittleboard.domain.board.entity.Board;
import com.fis.mylittleboard.domain.board.repository.BoardRepository;
import com.fis.mylittleboard.domain.card.repository.card.CardRepository;
import com.fis.mylittleboard.domain.card.repository.date.DateRepository;
import com.fis.mylittleboard.domain.progress.entity.Progress;
import com.fis.mylittleboard.domain.progress.repository.ProgressRepository;
import com.fis.mylittleboard.domain.progress.service.ProgressServiceImpl;
import java.util.stream.LongStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class ProcessServiceTest implements CommonTest {


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
				TestUtils.setProgress(progress, Progress_Name, Board_Id);
				progressRepository.save(progress);
			});

	}

	void testBoard() {
		Board board = new Board();
		TestUtils.setBoard(board, "workspaceA", "내용", "skyblue", 1L);
		boardRepository.save(board);
	}


}
