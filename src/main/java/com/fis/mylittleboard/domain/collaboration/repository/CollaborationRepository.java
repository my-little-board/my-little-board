package com.fis.mylittleboard.domain.collaboration.repository;

import com.fis.mylittleboard.domain.collaboration.entity.Collaboration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollaborationRepository extends JpaRepository<Collaboration, Long> {

}
