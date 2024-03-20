package com.fis.mylittleboard.domain.function.repository;

import com.fis.mylittleboard.domain.function.entity.Function;
import java.util.Optional;

public interface FunctionRepository {

	void save(Function function);

	Optional<Function> findById(Long id);
}
