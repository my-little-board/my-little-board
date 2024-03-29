package com.fis.mylittleboard.domain.board.repository;

import com.fis.mylittleboard.domain.board.entity.Board;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class BoardRepositoryImpl implements BoardRepository {

  private final BoardJpaRepository boardJpaRepository;
  private final JPAQueryFactory jpaQueryFactory;

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
  public List<Board> findAllBoardsOrderByBoardStatusDesc() {
    return boardJpaRepository.findAll(Sort.by(Direction.DESC, "boardStatus"));
  }

  @Override
  public void deleteById(Long boardId) {
    boardJpaRepository.deleteById(boardId);
  }

  @Override
  public Board findById(Long boardId) {
    return boardJpaRepository.findById(boardId).orElseThrow(() ->
        new IllegalArgumentException("작업공간이 존재하지 않습니다."));
  }

}
