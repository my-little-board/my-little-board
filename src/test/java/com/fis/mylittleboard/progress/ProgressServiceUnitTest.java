package com.fis.mylittleboard.progress;

import com.fis.mylittleboard.CommonTest;
import com.fis.mylittleboard.TestUtils;
import com.fis.mylittleboard.domain.board.entity.Board;
import com.fis.mylittleboard.domain.board.repository.BoardRepository;
import com.fis.mylittleboard.domain.card.repository.card.CardRepository;
import com.fis.mylittleboard.domain.card.repository.date.DateRepository;
import com.fis.mylittleboard.domain.progress.dto.ProgressResDto;
import com.fis.mylittleboard.domain.progress.entity.Progress;
import com.fis.mylittleboard.domain.progress.repository.ProgressRepository;
import com.fis.mylittleboard.domain.progress.service.ProgressServiceImpl;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.util.ReflectionTestUtils;

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
		TestUtils.setBoard(board, "workspaceA", "내용", "skyblue", 1L);
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
		TestUtils.setProgress(progress, Progress_Name, Board_Id);
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
		TestUtils.setProgress(progress, Progress_Name, Board_Id);
		when(boardRepository.findById(Board_Id)).thenThrow(
			new IllegalArgumentException("작업공간이 존재하지 않습니다."));

		// when
		Exception exception = assertThrows(IllegalArgumentException.class,
			() -> progressService.createProgress(Board_Id, Progress_Name));

		// then
		assertEquals("작업공간이 존재하지 않습니다.", exception.getMessage());


	}

	@Test
	@DisplayName("컬럼 수정 테스트")
	void 컬럼_수정_테스트() {
		// given
		Progress progress = Test_Progress;
		given(progressRepository.findById(progress.getId())).willReturn(Optional.of(progress));

		// when
		progressService.updateProgress(progress.getId(), "new name");

		// then
		assertEquals("new name", progress.getClassification());

	}

	@Test
	@DisplayName("컬럼 삭제 테스트")
	void 컬럼_삭제_테스트() {
		// given
		Progress progress = Test_Progress;
		given(progressRepository.findById(progress.getId())).willReturn(Optional.of(progress));

		// when
		progressService.deleteProgress(progress.getId());

		// then
	}

//	@Test
//	@DisplayName("컬럼 이동 테스트")
//	void 컬럼_이동_테스트() {
//		// given
//		Progress progress1 = Test_Progress;
//		Progress progress2 = Another_Test_Progress;
//		Board board = testBoard();
//
//		given(progressRepository.findById(progress1.getId())).willReturn(Optional.of(progress1));
//		given(progressRepository.findByPosition(progress2.getId())).willReturn(Optional.of(progress2));
//		given(boardRepository.findById(board.getId())).willReturn(board);
//
//		// when
//		progressService.move(progress1.getId(), board.getId(), 2L);
//		// then
//		// Verification
//		verify(progressRepository).save(progress1);
//		verify(progressRepository).save(progress2);
//
//		assertEquals(2L, progress1.getPosition());
//		assertEquals(1L, progress2.getPosition());
//		assertEquals(1L, progress1.getBoardId());
//		assertEquals(1L, progress2.getBoardId());
//	}

}
