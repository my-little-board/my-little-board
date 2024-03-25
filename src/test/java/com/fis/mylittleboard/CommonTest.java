package com.fis.mylittleboard;

import com.fis.mylittleboard.domain.card.entity.Card;
import com.fis.mylittleboard.domain.label.entity.Label;
import com.fis.mylittleboard.domain.progress.entity.Progress;

public interface CommonTest {

  String Progress_Name = "BackLog";

  String Label_Title = "Study";
  Long Board_Id = 1L;

  Long Progress_Id = 1L;


  Progress Test_Progress = Progress.builder()
      .boardId(Board_Id)
      .classification(Progress_Name)
      .position(1L)
      .build();

  Label Test_Label = Label.builder()
      .id(1L)
      .boardId(Board_Id)
      .title(Label_Title)
      .color("default color").build();

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
