package com.fis.mylittleboard.label;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import com.fis.mylittleboard.CommonTest;
import com.fis.mylittleboard.TestUtils;
import com.fis.mylittleboard.domain.board.entity.Board;
import com.fis.mylittleboard.domain.board.repository.BoardRepository;
import com.fis.mylittleboard.domain.label.dto.LabelResponseDto;
import com.fis.mylittleboard.domain.label.entity.Label;
import com.fis.mylittleboard.domain.label.repository.LabelRepository;
import com.fis.mylittleboard.domain.label.service.LabelServiceImpl;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LabelServiceUnitTest implements CommonTest {

  @Mock
  LabelRepository labelRepository;

  @Mock
  BoardRepository boardRepository;

  @InjectMocks
  LabelServiceImpl labelService;

  Board testBoard() {
    Board board = new Board();
    TestUtils.setBoard(board, "workspaceA", "내용", "skyblue", 1L);
    return board;
  }

  @Test
  @DisplayName("라벨 생성 테스트")
  void 라벨_생성_테스트() {
    // given
    Label label = Test_Label;
    Board board = testBoard();
    given(boardRepository.findById(any(Long.class))).willReturn(board);
    given(labelRepository.save(any(Label.class))).willReturn(label);

    // when
    LabelResponseDto result = labelService.createLabel(Board_Id, Label_Title, "default color");

    // then
    LabelResponseDto expect = new LabelResponseDto(label);
    assertEquals(result.getTitle(), expect.getTitle());
    assertEquals(result.getColor(), expect.getColor());
  }

  @Test
  @DisplayName("라벨 수정 테스트")
  void 라벨_수정_테스트() {
    // given
    Label label = Test_Label;
    given(labelRepository.findById(label.getId())).willReturn(Optional.of(label));

    // when
    LabelResponseDto labelResponseDto = labelService.updateLabel(label.getId(), "new title",
        "new color");

    // then
    assertEquals("new title", labelResponseDto.getTitle());
    assertEquals("new color", labelResponseDto.getColor());
  }
}
