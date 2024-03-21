package com.fis.mylittleboard.domain.hahacontent.repository;

import com.fis.mylittleboard.domain.hahacontent.entity.HahaContent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class HahaContentRepositoryImpl implements HahaContentRepository{

  private final HahaContentJpaRepository hahacontentJpaRepository;

  @Override
  public void save(HahaContent hahaContent) {
    hahacontentJpaRepository.save(hahaContent);
  }

}
