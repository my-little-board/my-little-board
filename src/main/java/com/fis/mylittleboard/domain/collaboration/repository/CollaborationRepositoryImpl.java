package com.fis.mylittleboard.domain.collaboration.repository;

import com.fis.mylittleboard.domain.collaboration.entity.Collaboration;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class CollaborationRepositoryImpl implements CollaborationRepository {

  private final CollaborationJpaRepository collaborationJpaRepository;

  @Override
  public void save(Collaboration collaboration) {
    collaborationJpaRepository.save(collaboration);
  }

  @Override
  public void deleteById(Long boardId) {
    collaborationJpaRepository.deleteById(boardId);
  }
}
