package com.fis.mylittleboard.domain.function;

import com.fis.mylittleboard.domain.function.entity.Function;
import com.fis.mylittleboard.domain.function.repository.FunctionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FunctionService {

	private final FunctionRepository functionRepository;

	public void createFunctions() {
		saveFunctions("Members");
		saveFunctions("Dates");
		saveFunctions("Labels");

	}

	public void saveFunctions(String name) {
		Function function = new Function(name);
		functionRepository.save(function);
	}

}
