package com.fis.mylittleboard.domain.board.serivce;

import com.fis.mylittleboard.domain.board.dto.BoardRequestDto;
import com.fis.mylittleboard.domain.board.dto.BoardResponseDto;
import com.fis.mylittleboard.domain.board.entity.Board;
import com.fis.mylittleboard.domain.board.repository.BoardRepository;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.swing.text.html.FormView;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {

  private final BoardRepository boardRepository;

  @Transactional
  public void createBoard(BoardRequestDto requestDto) {

    Long userId = 1L;

    String boardName = requestDto.getBoardName();
    Optional<Board> checkBoardName = boardRepository.findByBoardName(boardName);
    if (checkBoardName.isPresent()) {
      throw new IllegalArgumentException("사용중인 작업공간입니다.");
    }
    Board board = new Board(
        requestDto.getBoardName(),
        requestDto.getBoardDescription(),
        requestDto.getBoardColor(),
        userId
    );

    boardRepository.save(board);
    // todo: 현재 진행상황을 표현하는 방법
  }

  @Transactional(readOnly = true)
  public List<BoardResponseDto> getBoardProgressing() {
    List<BoardResponseDto> boardResponseDtoList = new ArrayList<>();
    for (Board board : boardRepository.findAll()) {
      if (board.isClassification()) {
        boardResponseDtoList.add(
            new BoardResponseDto(
                board.getBoardName(),
                board.getBoardDescription(),
                board.getBoardColor(),
                board.getDueDate()));
      }
    }
    return boardResponseDtoList;
  }

  public List<BoardResponseDto> getBoardClosing() {
    List<BoardResponseDto> boardResponseDtoList = new ArrayList<>();
    for(Board board : boardRepository.findAll()) {
      if (!board.isClassification()) {
        boardResponseDtoList.add(
            new BoardResponseDto(
                board.getBoardName(),
                board.getBoardDescription(),
                board.getBoardColor(),
                board.getDueDate()));
      }
    }
    return boardResponseDtoList;
  }
}
