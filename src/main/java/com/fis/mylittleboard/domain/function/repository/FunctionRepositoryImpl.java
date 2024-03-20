package com.fis.mylittleboard.domain.function.repository;

import com.fis.mylittleboard.domain.function.entity.Function;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FunctionRepositoryImpl implements FunctionRepository{

	private final FunctionJpaRepository functionJpaRepository;


	@Override
	public void save(Function function) {
		functionJpaRepository.save(function);
	}
}
