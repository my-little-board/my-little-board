package com.fis.mylittleboard.domain.board.controller;

import com.fis.mylittleboard.domain.board.dto.BoardRequestDto;
import com.fis.mylittleboard.domain.board.dto.BoardResponseDto;
import com.fis.mylittleboard.domain.board.serivce.BoardService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/boards")
public class BoardController {

  private final BoardService boardService;

  @PostMapping
  public String createBoard (
      @RequestBody BoardRequestDto requestDto) {
    // todo: 기능구현 후 마감기한 설정하는 부분 dto와 같이 생각해서 설정
    boardService.createBoard(requestDto);

    return "작업공간이 생성되었습니다.";
  }

  @GetMapping("/progress")
  public ResponseEntity<List<BoardResponseDto>> getBoardProgressing() {
    List<BoardResponseDto> responseDtoList = boardService.getBoardProgressing();

    return new ResponseEntity<>(responseDtoList, HttpStatus.OK);
  }

  @GetMapping("/close")
  public ResponseEntity<List<BoardResponseDto>> getBoardClosing() {
    List<BoardResponseDto> responseDtoList = boardService.getBoardClosing();

    return new ResponseEntity<>(responseDtoList, HttpStatus.OK);
  }

  @PutMapping("/{boardId}")
  public String updateBoard(
      @PathVariable Long boardId,
      @RequestBody BoardRequestDto requestDto) {
    boardService.updateBoard(boardId, requestDto);
    
    return "워크스페이스가 수정되었습니다.";
  }

  @DeleteMapping("/{boardId}")
  public String deleteBoard(
      @PathVariable Long boardId) {
    boardService.deleteBoard(boardId);

    return "워크스페이스가 삭제되었습니다.";
  }
}
