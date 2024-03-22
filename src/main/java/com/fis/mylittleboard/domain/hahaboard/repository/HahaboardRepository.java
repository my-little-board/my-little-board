package com.fis.mylittleboard.domain.hahaboard.repository;

import com.fis.mylittleboard.domain.hahaboard.entity.Hahaboard;
import java.util.List;

public interface HahaboardRepository {

  Hahaboard save(Hahaboard hahaboard);

  void deleteById(Long boardId);

  List<Hahaboard> findHahaboardByInBoardId(Long boardId);

}
