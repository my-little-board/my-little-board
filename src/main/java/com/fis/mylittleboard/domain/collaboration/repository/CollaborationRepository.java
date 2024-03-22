package com.fis.mylittleboard.domain.collaboration.repository;

import com.fis.mylittleboard.domain.collaboration.entity.Collaboration;

public interface CollaborationRepository {

  void save(Collaboration collaboration);

  void deleteById(Long BoardId);
}
