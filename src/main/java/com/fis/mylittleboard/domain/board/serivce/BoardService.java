package com.fis.mylittleboard.domain.board.serivce;

import com.fis.mylittleboard.domain.board.dto.BoardRequestDto;
import com.fis.mylittleboard.domain.board.dto.BoardResponseDto;
import java.util.List;

public interface BoardService {

  void createBoard (BoardRequestDto requestDto);

  List<BoardResponseDto> getBoardProgressing();

  List<BoardResponseDto> getBoardClosing();

  void updateBoard(Long boardId, BoardRequestDto requestDto);

  void deleteBoard(Long boardId);

}
