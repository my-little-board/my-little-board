package com.fis.mylittleboard;


import com.fis.mylittleboard.domain.card.entity.Card;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.test.util.ReflectionTestUtils;

public class TestUtils implements CommonTest {
  //String boardName, String boardDescription, String boardColor, Long userId


  public static <T> void setProgress(T entity, String classification, Long boardId) {
    ReflectionTestUtils.setField(entity, "id", 1L);
    ReflectionTestUtils.setField(entity, "classification", classification);
    ReflectionTestUtils.setField(entity, "boardId", boardId);
    ReflectionTestUtils.setField(entity, "position", 1L);
  }

  public static <T> void setBoard(
      T entity, String boardName, String boardDescription,
      String boardColor, Long userId) {
    ReflectionTestUtils.setField(entity, "boardName", boardName);
    ReflectionTestUtils.setField(entity, "boardDescription", boardDescription);
    ReflectionTestUtils.setField(entity, "boardColor", boardColor);
    ReflectionTestUtils.setField(entity, "userId", userId);
    ReflectionTestUtils.setField(entity, "dueDate", LocalDateTime.now());
  }


}
