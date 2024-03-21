package com.fis.mylittleboard.domain.board.repository;

import com.fis.mylittleboard.domain.board.entity.Board;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class BoardRepositoryImpl implements BoardRepository{

  private final BoardJpaRepository boardJpaRepository;

  @Override
  public Board save(Board board) {
    return boardJpaRepository.save(board);
  }

  @Override
  public Optional<Board> findByBoardName(String boardName) {
    return boardJpaRepository.findByBoardName(boardName);
  }

  @Override
  public List<Board> findAll() {
    return boardJpaRepository.findAll();
  }

  @Override
  public void deleteById(Long boardId) {
    boardJpaRepository.deleteById(boardId);
  }

  @Override
  public Board findById(Long boardId) {
    boardJpaRepository.findById(boardId).orElseThrow(() ->
        new IllegalArgumentException("작업공간이 존재하지 않습니다."));
    return null;
  }
}
