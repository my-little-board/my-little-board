package com.fis.mylittleboard.domain.board.serivce;

import com.fis.mylittleboard.domain.board.dto.BoardAllResponseDto;
import com.fis.mylittleboard.domain.board.dto.BoardRequestDto;
import com.fis.mylittleboard.domain.board.dto.BoardResponseDto;
import com.fis.mylittleboard.global.jwt.security.UserDetailsImpl;
import java.util.List;

public interface BoardService {

  void createBoard(BoardRequestDto requestDto, UserDetailsImpl userDetails);

  BoardResponseDto getBoard(Long boardId);

  List<BoardAllResponseDto> getBoardAllList();

  void updateBoard(Long boardId, BoardRequestDto requestDto, UserDetailsImpl userDetails);

  void deleteBoard(Long boardId, UserDetailsImpl userDetails);

}
