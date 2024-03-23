package com.fis.mylittleboard;

import com.fis.mylittleboard.domain.card.entity.Card;
import com.fis.mylittleboard.domain.progress.entity.Progress;
import java.util.ArrayList;
import java.util.List;

public interface CommonTest {

	String Progress_Name = "BackLog";
	Long Board_Id = 1L;

	Long Progress_Id = 1L;

	Long Another_Progress_Id = 2L;

	Progress Test_Progress = Progress.builder()
		.boardId(Board_Id)
		.classification(Progress_Name)
		.position(1L)
		.build();

	Progress Another_Test_Progress = Progress.builder()
		.boardId(Board_Id)
		.classification(Progress_Name)
		.position(2L)
		.build();

	Card Test_Card = Card.builder()
		.name("이름")
		.color("default color")
		.boardId(Board_Id)
		.progressId(Progress_Id)
		.build();
	Card Another_Test_Card = Card.builder()
		.name("이름")
		.color("default color")
		.boardId(Board_Id)
		.progressId(Progress_Id)
		.build();


}
