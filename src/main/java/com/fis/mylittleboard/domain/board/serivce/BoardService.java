package com.fis.mylittleboard.domain.board.serivce;

import com.fis.mylittleboard.domain.board.dto.BoardRequestDto;
import com.fis.mylittleboard.domain.board.dto.BoardResponseDto;
import com.fis.mylittleboard.domain.board.entity.Board;
import com.fis.mylittleboard.domain.board.repository.BoardRepository;
import com.fis.mylittleboard.domain.collaboration.entity.Collaboration;
import com.fis.mylittleboard.domain.collaboration.repository.CollaborationRepository;
import com.fis.mylittleboard.domain.hahaboard.entity.Hahaboard;
import com.fis.mylittleboard.domain.hahaboard.repository.HahaboardRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {

  private final BoardRepository boardRepository;
  private final CollaborationRepository collaborationRepository;
  private final HahaboardRepository hahaboardRepository;


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

    Board newBoard = boardRepository.save(board); // 워크스페이스 생성

    Hahaboard hahaboard = new Hahaboard(newBoard.getId());

    hahaboardRepository.save(hahaboard); // 생성된 워크스페이스와 같은 하하 워크스페이스 생성

    Collaboration collaboration = new Collaboration(newBoard.getId(), userId);

    collaborationRepository.save(collaboration); // 워크스페이스에 있는 유저들 관리공간 생성
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

  @Transactional(readOnly = true)

  public List<BoardResponseDto> getBoardClosing() {
    List<BoardResponseDto> boardResponseDtoList = new ArrayList<>();
    for (Board board : boardRepository.findAll()) {
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

  @Transactional
  public void updateBoard(Long boardId, BoardRequestDto requestDto) {
    Board board = boardRepository.findById(boardId).orElseThrow(() ->
        new IllegalArgumentException("일치하는 작업공간이 없습니다."));

    board.update(requestDto);
  }

  @Transactional
  public void deleteBoard(Long boardId) {
    boardRepository.deleteById(boardId);
  }

  /*
  todo: 워크스페이스는 생성 시 진행상황은 무조건 진행중인 상황이 될테니 default로 true를 주는게 맞나?
  todo: 워크스페이스에 다른 유저 초대하는 기능 구현
  todo: 배경색상 처리하는 방법
  todo: 마감기한 설정 및 마감기한 지나면 진행상황 false로 바꾸는 방법
  todo: 워크스페이스 수정 및 삭제는 생성자만 할 수 있게 처리

   */
}
