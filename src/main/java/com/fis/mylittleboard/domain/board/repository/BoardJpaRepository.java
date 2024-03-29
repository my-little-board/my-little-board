package com.fis.mylittleboard.domain.board.repository;

import com.fis.mylittleboard.domain.board.entity.Board;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardJpaRepository extends JpaRepository<Board, Long> {

  Optional<Board> findByBoardName(String boardName);

//  List<Board> findAllBoardsOrderByBoardStatus();

}
