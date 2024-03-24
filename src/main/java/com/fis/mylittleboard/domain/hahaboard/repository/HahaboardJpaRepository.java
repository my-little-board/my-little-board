package com.fis.mylittleboard.domain.hahaboard.repository;

import com.fis.mylittleboard.domain.hahaboard.entity.Hahaboard;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HahaboardJpaRepository extends JpaRepository<Hahaboard, Long> {

  List<Hahaboard> findByInBoardId(Long boardId);
}
