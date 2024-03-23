package com.fis.mylittleboard.label;

import com.fis.mylittleboard.CommonTest;
import com.fis.mylittleboard.domain.board.repository.BoardRepository;
import com.fis.mylittleboard.domain.label.repository.LabelRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LabelServiceUnitTest implements CommonTest {

	@Mock
	LabelRepository labelRepository;

	@Mock
	BoardRepository boardRepository;



}
