package com.fis.mylittleboard.domain.hahaboard.repository;

import com.fis.mylittleboard.domain.hahaboard.entity.Hahaboard;

public interface HahaboardRepository {

  Hahaboard save (Hahaboard hahaboard);

  void deleteById (Long boardId);

}
