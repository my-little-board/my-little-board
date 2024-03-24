package com.fis.mylittleboard.domain.hahacontent.repository;

import com.fis.mylittleboard.domain.hahacontent.entity.HahaContent;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HahaContentJpaRepository extends JpaRepository<HahaContent, Long> {

  List<HahaContent> findByHahaboardId(Long hahaboardId);

  void deleteAllById(Long boardId);
}
