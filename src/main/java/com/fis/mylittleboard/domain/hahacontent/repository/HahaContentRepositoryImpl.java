package com.fis.mylittleboard.domain.hahacontent.repository;

import com.fis.mylittleboard.domain.hahacontent.entity.HahaContent;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class HahaContentRepositoryImpl implements HahaContentRepository {

  private final HahaContentJpaRepository hahacontentJpaRepository;

  @Override
  public void save(HahaContent hahaContent) {
    hahacontentJpaRepository.save(hahaContent);
  }

  @Override
  public List<HahaContent> findHahaContentsByHahaboardId(Long hahaboardId) {
    return hahacontentJpaRepository.findByHahaboardId(hahaboardId);
  }

  @Override
  public void deleteAllHahaContent(Long boardId) {
    hahacontentJpaRepository.deleteAllById(boardId);
  }

}
