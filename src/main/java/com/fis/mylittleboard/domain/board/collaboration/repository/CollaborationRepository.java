package com.fis.mylittleboard.domain.board.collaboration.repository;

import com.fis.mylittleboard.domain.board.collaboration.entity.Collaboration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollaborationRepository extends JpaRepository<Collaboration, Long> {

}
