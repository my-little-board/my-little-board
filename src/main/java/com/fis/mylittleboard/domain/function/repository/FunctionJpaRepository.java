package com.fis.mylittleboard.domain.function.repository;

import com.fis.mylittleboard.domain.function.entity.Function;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FunctionJpaRepository extends JpaRepository<Function, Long> {

}
