package com.fis.mylittleboard.domain.board.controller;

import com.fis.mylittleboard.domain.board.dto.BoardRequestDto;
import com.fis.mylittleboard.domain.board.dto.BoardAllResponseDto;
import com.fis.mylittleboard.domain.board.dto.BoardResponseDto;
import com.fis.mylittleboard.domain.board.serivce.BoardService;
import com.fis.mylittleboard.global.common.MessageResponseDto;
import com.fis.mylittleboard.global.common.ResponseDto;
import com.fis.mylittleboard.global.jwt.security.UserDetailsImpl;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
      @RequestBody BoardRequestDto requestDto,
      @AuthenticationPrincipal UserDetailsImpl userDetails) {
    boardService.createBoard(requestDto, userDetails);

    return ResponseEntity.ok()
        .body(MessageResponseDto.builder()
            .message("워크스페이스가 생성되었습니다.")
            .build());
  }

  @GetMapping("/{boardId}")
  public ResponseEntity<BoardResponseDto> getBoard(
      @PathVariable Long boardId) {
    BoardResponseDto responseDtoList = boardService.getBoard(boardId);

    return ResponseEntity.ok()
        .body(ResponseDto.<BoardResponseDto>builder()
            .data(responseDtoList)
            .build()
            .getData());
  }

  @GetMapping("/hahaboards/progresses/cards")
  public ResponseEntity<List<BoardAllResponseDto>> getBoardAllList() {
    List<BoardAllResponseDto> responseDtoList = boardService.getBoardAllList();

    return ResponseEntity.ok()
        .body(ResponseDto.<List<BoardAllResponseDto>>builder()
            .data(responseDtoList)
            .build()
            .getData());
  }

  @PutMapping("/{boardId}")
  public ResponseEntity<MessageResponseDto> updateBoard(
      @PathVariable Long boardId,
      @RequestBody BoardRequestDto requestDto,
      @AuthenticationPrincipal UserDetailsImpl userDetails) {
    boardService.updateBoard(boardId, requestDto, userDetails);

    return ResponseEntity.ok()
        .body(MessageResponseDto.builder()
            .message("워크스페이스가 수정되었습니다.")
            .build());
  }

  @DeleteMapping("/{boardId}")
  public ResponseEntity<MessageResponseDto> deleteBoard(
      @PathVariable Long boardId,
      @AuthenticationPrincipal UserDetailsImpl userDetails) {
    boardService.deleteBoard(boardId, userDetails);

    return ResponseEntity.ok()
        .body(MessageResponseDto.builder()
            .message("워크스페이스가 삭제되었습니다.")
            .build());
  }
}
