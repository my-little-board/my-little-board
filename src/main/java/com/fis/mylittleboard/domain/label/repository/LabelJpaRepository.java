package com.fis.mylittleboard.domain.label.repository;

import com.fis.mylittleboard.domain.label.entity.Label;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabelJpaRepository extends JpaRepository<Label, Long> {

}
