package com.fis.mylittleboard.domain.hahaboard.repository;

import com.fis.mylittleboard.domain.hahaboard.entity.Hahaboard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class HahaboardRepositoryImpl implements HahaboardRepository {

  private final HahaboardJpaRepository hahaboardJpaRepository;

  @Override
  public Hahaboard save(Hahaboard hahaboard) {
    return hahaboardJpaRepository.save(hahaboard);
  }

  @Override
  public void deleteById (Long boardId) {
    hahaboardJpaRepository.deleteById(boardId);
  }
}
