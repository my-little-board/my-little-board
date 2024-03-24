package com.fis.mylittleboard.domain.hahacontent.repository;

import com.fis.mylittleboard.domain.hahacontent.entity.HahaContent;
import java.util.List;

public interface HahaContentRepository {

  void save(HahaContent hahaContent);

  List<HahaContent> findHahaContentsByHahaboardId(Long hahaboardId);

  void deleteAllHahaContent(Long boardId);

}
