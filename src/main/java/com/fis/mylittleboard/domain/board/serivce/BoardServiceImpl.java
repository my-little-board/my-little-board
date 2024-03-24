package com.fis.mylittleboard.domain.board.serivce;

import com.fis.mylittleboard.domain.board.dto.BoardAllResponseDto;
import com.fis.mylittleboard.domain.board.dto.BoardRequestDto;
import com.fis.mylittleboard.domain.board.dto.BoardResponseDto;
import com.fis.mylittleboard.domain.board.entity.Board;
import com.fis.mylittleboard.domain.board.repository.BoardRepository;
import com.fis.mylittleboard.domain.card.repository.card.CardRepository;
import com.fis.mylittleboard.domain.collaboration.entity.Collaboration;
import com.fis.mylittleboard.domain.collaboration.repository.CollaborationRepository;
import com.fis.mylittleboard.domain.hahaboard.entity.Hahaboard;
import com.fis.mylittleboard.domain.hahaboard.repository.HahaboardRepository;
import com.fis.mylittleboard.domain.hahacontent.repository.HahaContentRepository;
import com.fis.mylittleboard.domain.progress.repository.ProgressRepository;
import com.fis.mylittleboard.global.jwt.security.UserDetailsImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

  private final BoardRepository boardRepository;
  private final CollaborationRepository collaborationRepository;
  private final HahaboardRepository hahaboardRepository;
  private final HahaContentRepository hahaContentRepository;
  private final ProgressRepository progressRepository;
  private final CardRepository cardRepository;


  @Override
  @Transactional
  public void createBoard(BoardRequestDto requestDto, UserDetailsImpl userDetails) {
    String boardName = requestDto.getBoardName();
    Optional<Board> checkBoard = boardRepository.findByBoardName(boardName);
    if (checkBoard.isPresent() &&
        Objects.equals(checkBoard.get().getUserId(), userDetails.getUser().getId())) {
      throw new IllegalArgumentException("사용중인 작업공간입니다.");
    }
    Board board = new Board(
        requestDto.getBoardName(),
        requestDto.getBoardDescription(),
        requestDto.getBoardColor(),
        userDetails.getUser().getId()
    );

    Board newBoard = boardRepository.save(board); // 워크스페이스 생성

    String hahaboardName = requestDto.getHahaboardName();
    Hahaboard hahaboard = new Hahaboard(newBoard.getId(), hahaboardName);
    hahaboardRepository.save(hahaboard); // 생성된 워크스페이스와 같은 하하 워크스페이스 생성

    Collaboration collaboration = new Collaboration(
        newBoard.getId(), userDetails.getUser().getId());

    collaborationRepository.save(collaboration); // 워크스페이스에 있는 유저들 관리공간 생성
  }

  @Override
  @Transactional(readOnly = true)
  public BoardResponseDto getBoard(Long boardId) {
    Board board = findBoard(boardId);
    BoardResponseDto boardResponseDto = new BoardResponseDto(
        board.getBoardStatus(),
        board.getBoardName(),
        board.getBoardDescription(),
        board.getBoardColor());

    return boardResponseDto;
  }

  @Override
  @Transactional(readOnly = true)
  public List<BoardAllResponseDto> getBoardAllList() {
    List<BoardAllResponseDto> boardAllResponseDtoList = new ArrayList<>();
    for (Board board : boardRepository.findAll()) {
      boardAllResponseDtoList.add(
          new BoardAllResponseDto(
              board.getBoardStatus(),
              board.getBoardName()));
    }
    return boardAllResponseDtoList;
  }

  @Override
  @Transactional
  public void updateBoard(Long boardId, BoardRequestDto requestDto, UserDetailsImpl userDetails) {
    Board board = findBoard(boardId);
    if (!Objects.equals(board.getUserId(), userDetails.getUser().getId())) {
      throw new IllegalArgumentException("워크스페이스 생성자만 수정할 수 있습니다.");
    }
    if (!board.getBoardStatus()) {
      throw new IllegalArgumentException("마감된 워크스페이스는 수정할 수 없습니다.");
    }

    board.update(requestDto);
  }

  @Override
  @Transactional
  public void deleteBoard(Long boardId, UserDetailsImpl userDetails) {
    Board board = findBoard(boardId);
    if (!Objects.equals(board.getUserId(), userDetails.getUser().getId())) {
      throw new IllegalArgumentException("워크스페이스 생성자만 삭제할 수 있습니다.");
    }

    cardRepository.deleteAllCard(boardId);
    progressRepository.deleteAllProgress(boardId);
    hahaContentRepository.deleteAllHahaContent(boardId);
    hahaboardRepository.deleteById(boardId);
    collaborationRepository.deleteById(boardId);
    boardRepository.deleteById(boardId);
  }

  private Board findBoard(Long boardId) {
    return boardRepository.findById(boardId);
  }
}
