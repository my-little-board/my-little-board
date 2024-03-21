package com.fis.mylittleboard.domain.hahaboard.repository;

import com.fis.mylittleboard.domain.board.entity.Board;
import com.fis.mylittleboard.domain.hahaboard.entity.Hahaboard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HahaboardRepository {

  Hahaboard save (Hahaboard hahaboard);

  void deleteById (Long boardId);

}
