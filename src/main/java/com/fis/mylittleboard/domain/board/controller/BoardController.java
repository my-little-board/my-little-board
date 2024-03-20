package com.fis.mylittleboard.domain.board.controller;

import com.fis.mylittleboard.domain.board.dto.BoardRequestDto;
import com.fis.mylittleboard.domain.board.dto.BoardResponseDto;
import com.fis.mylittleboard.domain.board.serivce.BoardService;
import com.fis.mylittleboard.global.common.MessageResponseDto;
import com.fis.mylittleboard.global.common.ResponseDto;
import java.util.List;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
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
  public ResponseEntity<MessageResponseDto> createBoard(
      @RequestBody BoardRequestDto requestDto) {
    boardService.createBoard(requestDto);

    return ResponseEntity.ok()
        .body(MessageResponseDto.builder()
            .message("워크스페이스가 생성되었습니다.")
            .build());
  }

  @GetMapping("/progress")
  public ResponseEntity<List<BoardResponseDto>> getBoardProgressing() {
    List<BoardResponseDto> responseDtoList = boardService.getBoardProgressing();

    return ResponseEntity.ok()
        .body(ResponseDto.<List<BoardResponseDto>>builder()
            .data(responseDtoList)
            .build()
            .getData());
  }

  @GetMapping("/close")
  public ResponseEntity<List<BoardResponseDto>> getBoardClosing() {
    List<BoardResponseDto> responseDtoList = boardService.getBoardClosing();

    return ResponseEntity.ok()
        .body(ResponseDto.<List<BoardResponseDto>>builder()
            .data(responseDtoList)
            .build()
            .getData());
  }

  @PutMapping("/{boardId}")
  public ResponseEntity<MessageResponseDto> updateBoard(
      @PathVariable Long boardId,
      @RequestBody BoardRequestDto requestDto) {
    boardService.updateBoard(boardId, requestDto);

    return ResponseEntity.ok()
        .body(MessageResponseDto.builder()
            .message("워크스페이스가 수정되었습니다.")
            .build());
  }

  @DeleteMapping("/{boardId}")
  public ResponseEntity<MessageResponseDto> deleteBoard(
      @PathVariable Long boardId) {
    boardService.deleteBoard(boardId);

    return ResponseEntity.ok()
        .body(MessageResponseDto.builder()
            .message("워크스페이스가 삭제되었습니다.")
            .build());
  }
}
