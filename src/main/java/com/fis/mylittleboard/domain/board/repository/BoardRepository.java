package com.fis.mylittleboard.domain.board.repository;

import com.fis.mylittleboard.domain.board.entity.Board;
import java.util.List;
import java.util.Optional;

public interface BoardRepository {

  Board save(Board board);

  Optional<Board> findByBoardName(String boardName);

  List<Board> findAllBoardsOrderByBoardStatusDesc();

  void deleteById(Long boardId);

  Board findById(Long boardId);
}
