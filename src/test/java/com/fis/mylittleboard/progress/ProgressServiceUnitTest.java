package com.fis.mylittleboard.progress;

import com.fis.mylittleboard.domain.board.entity.Board;
import com.fis.mylittleboard.domain.board.repository.BoardRepository;
import com.fis.mylittleboard.domain.card.repository.card.CardRepository;
import com.fis.mylittleboard.domain.card.repository.date.DateRepository;
import com.fis.mylittleboard.domain.progress.dto.ProgressResDto;
import com.fis.mylittleboard.domain.progress.entity.Progress;
import com.fis.mylittleboard.domain.progress.repository.ProgressRepository;
import com.fis.mylittleboard.domain.progress.service.ProgressServiceImpl;
import java.util.stream.LongStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.util.ReflectionTestUtils;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class ProgressServiceUnitTest implements CommonTest {

	@Mock
	ProgressRepository progressRepository;
	@Mock
	CardRepository cardRepository;
	@Mock
	BoardRepository boardRepository;
	@Mock
	DateRepository dateRepository;

	@InjectMocks
	ProgressServiceImpl progressService;

	Board testBoard() {
		Board board = new Board();
		ProgressTestUtils.setBoard(board, "workspaceA", "내용", "skyblue", 1L);
		return board;
	}

	private <T> void setDto(T dto, String username, String password) {
		ReflectionTestUtils.setField(dto, "username", username);
		ReflectionTestUtils.setField(dto, "password", password);
	}

	@Test
	@DisplayName("컬럼 생성 성공 테스트")
	void 컬럼_생성_성공() {
		// given
		Board board = testBoard();
		Progress progress = new Progress();
		ProgressTestUtils.setProgress(progress, Progress_Name, Board_Id);
		given(boardRepository.findById(any(Long.class))).willReturn(board);
		given(progressRepository.save(any(Progress.class))).willReturn(progress);

		//when
		ProgressResDto result = progressService.createProgress(Board_Id, Progress_Name);

		// then
		ProgressResDto expect = new ProgressResDto(progress);
		assertEquals(result.getClassification(), expect.getClassification());

	}

	@Test
	@DisplayName("컬럼 생성 실패 테스트")
	void 컬럼_생성_실패() {
		// given
		Progress progress = new Progress();
		ProgressTestUtils.setProgress(progress, Progress_Name, Board_Id);
		when(boardRepository.findById(Board_Id)).thenThrow(
			new IllegalArgumentException("작업공간이 존재하지 않습니다."));

		// when
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			progressService.createProgress(Board_Id, Progress_Name);
		});

		// then
		assertEquals("작업공간이 존재하지 않습니다.", exception.getMessage());


	}

}
