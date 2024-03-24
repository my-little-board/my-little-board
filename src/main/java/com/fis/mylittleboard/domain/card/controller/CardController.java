package com.fis.mylittleboard.domain.card.controller;

import com.fis.mylittleboard.domain.card.dto.CardColorRequestDto;
import com.fis.mylittleboard.domain.card.dto.CardColorResponseDto;
import com.fis.mylittleboard.domain.card.dto.CardDatesRequestDto;
import com.fis.mylittleboard.domain.card.dto.CardDatesResDto;
import com.fis.mylittleboard.domain.card.dto.CardDescriptionDto;
import com.fis.mylittleboard.domain.card.dto.CardDescriptionResponseDto;
import com.fis.mylittleboard.domain.card.dto.CardLabelReqDto;
import com.fis.mylittleboard.domain.card.dto.CardListResDto;
import com.fis.mylittleboard.domain.card.dto.CardNameRequestDto;
import com.fis.mylittleboard.domain.card.dto.CardNameResDto;
import com.fis.mylittleboard.domain.card.dto.CardResponseDto;
import com.fis.mylittleboard.domain.card.dto.MemberReqDto;
import com.fis.mylittleboard.domain.card.dto.MemberResDto;
import com.fis.mylittleboard.domain.card.service.CardService;
import com.fis.mylittleboard.domain.label.dto.LabelResponseDto;
import com.fis.mylittleboard.global.common.MessageResponseDto;
import com.fis.mylittleboard.global.common.ResponseDto;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CardController {

  private final CardService cardService;

  //boardId와 progressId 검증

  @PostMapping("/api/cards")
  public ResponseEntity<ResponseDto<CardNameResDto>> createCard(
      @Valid @RequestBody CardNameRequestDto cardNameRequestDto) {
    CardNameResDto cardNameResDto = cardService.createCard(cardNameRequestDto);

    return ResponseEntity.ok()
        .body(ResponseDto.<CardNameResDto>builder()
            .message("카드 생성에 성공하였습니다.")
            .data(cardNameResDto)
            .build());
  }


  @PostMapping("/api/cards/{cardId}/functions/dates")
  public ResponseEntity<ResponseDto<CardDatesResDto>> addDate(
      @PathVariable Long cardId,
      @RequestBody CardDatesRequestDto cardDatesRequestDto) {
    CardDatesResDto cardDatesResDto = cardService.addDate(cardId,
        cardDatesRequestDto);

    return ResponseEntity.ok()
        .body(ResponseDto.<CardDatesResDto>builder()
            .message("DueDate 등록에 성공하였습니다.")
            .data(cardDatesResDto)
            .build());
  }

  @PostMapping("/api/cards/{cardId}/functions/members")
  public ResponseEntity<ResponseDto<MemberResDto>> addMember(
      @PathVariable Long cardId,
      @RequestBody MemberReqDto memberReqDto) {
    MemberResDto memberResDto = cardService.addMember(cardId, memberReqDto.getUsername());

    return ResponseEntity.ok()
        .body(ResponseDto.<MemberResDto>builder()
            .message("DueDate 등록에 성공하였습니다.")
            .data(memberResDto)
            .build());
  }

  @PostMapping("/api/cards/{cardId}/functions/labels/{labelId}")
  public ResponseEntity<ResponseDto<LabelResponseDto>> addLabel(
      @PathVariable Long cardId,
      @PathVariable Long labelId) {
    LabelResponseDto labelResponseDto = cardService.addLabel(cardId, labelId);

    return ResponseEntity.ok()
        .body(ResponseDto.<LabelResponseDto>builder()
            .message("카드 라벨 등록에 성공하였습니다.")
            .data(labelResponseDto)
            .build());
  }


  @PatchMapping("/api/cards/{cardId}/descriptions")
  public ResponseEntity<ResponseDto<CardDescriptionResponseDto>> updateDescription(
      @PathVariable Long cardId, @RequestBody CardDescriptionDto cardDescriptionDto) {
    String description = cardDescriptionDto.getDescription();

    CardDescriptionResponseDto cardDescriptionResponseDto = cardService.updateDescription(
        cardId, description);

    return ResponseEntity.ok()
        .body(ResponseDto.<CardDescriptionResponseDto>builder()
            .message("description 수정에 성공하였습니다.")
            .data(cardDescriptionResponseDto)
            .build());
  }


  @PatchMapping("/api/cards/{cardId}/colors")
  public ResponseEntity<ResponseDto<CardColorResponseDto>> updateColor(
      @PathVariable Long cardId, @RequestBody CardColorRequestDto cardColorRequestDto) {
    CardColorResponseDto cardColorResponseDto = cardService.updateColor(cardId,
        cardColorRequestDto.getColor());

    return ResponseEntity.ok()
        .body(ResponseDto.<CardColorResponseDto>builder()
            .message("color 수정에 성공하였습니다.")
            .data(cardColorResponseDto)
            .build());
  }


  @PatchMapping("/api/cards/functions/dates/{dateId}")
  public ResponseEntity<ResponseDto<CardDatesResDto>> updateDate(
      @PathVariable Long dateId, @RequestBody
  CardDatesRequestDto cardDatesRequestDto) {
    CardDatesResDto cardDatesResDto = cardService.updateDate(dateId,
        cardDatesRequestDto);

    return ResponseEntity.ok()
        .body(ResponseDto.<CardDatesResDto>builder()
            .message("DueDate 수정에 성공하였습니다.")
            .data(cardDatesResDto)
            .build());
  }


  @DeleteMapping("/api/cards/functions/dates/{dateId}")
  public ResponseEntity<MessageResponseDto> deleteDate(@PathVariable Long dateId) {
    cardService.deleteDate(dateId);

    return ResponseEntity.ok()
        .body(MessageResponseDto.builder()
            .message("해당 카드의 date 기능 삭제에 성공하였습니다.")
            .build());
  }


  @DeleteMapping("/api/cards/{cardId}")
  public ResponseEntity<MessageResponseDto> deleteCard(@PathVariable Long cardId) {
    cardService.deleteCard(cardId);

    return ResponseEntity.ok()
        .body(MessageResponseDto.builder()
            .message("카드 삭제에 성공하였습니다.")
            .build());
  }

  @DeleteMapping("/api/cards/functions/members/{memberId}")
  public ResponseEntity<MessageResponseDto> deleteMember(@PathVariable Long memberId) {
    cardService.deleteMember(memberId);

    return ResponseEntity.ok()
        .body(MessageResponseDto.builder()
            .message("해당 멤버 제거에 성공하였습니다.")
            .build());
  }

  @DeleteMapping("/api/cards/functions/labels/{cardLabelId}")
  public ResponseEntity<MessageResponseDto> deleteCardLabel(@PathVariable Long cardLabelId) {
    cardService.deleteCardLabel(cardLabelId);

    return ResponseEntity.ok()
        .body(MessageResponseDto.builder()
            .message("해당 카드 라벨 제거에 성공하였습니다.")
            .build());
  }

  @GetMapping("/api/cards/{cardId}")
  public ResponseEntity<ResponseDto<CardResponseDto>> getCard(@PathVariable Long cardId) {
    CardResponseDto cardResponseDto = cardService.getCard(cardId);

    return ResponseEntity.ok()
        .body(ResponseDto.<CardResponseDto>builder()
            .message("카드 조회에 성공하였습니다.")
            .data(cardResponseDto)
            .build());
  }

  @PostMapping("/api/boards/{boardId}/cards/labels")
  public ResponseEntity<ResponseDto<CardListResDto>> filterLabel(
      @PathVariable Long boardId,
      @RequestBody CardLabelReqDto cardLabelReqDto) {
    List<Long> filters = cardLabelReqDto.getLabelId();
    List<CardResponseDto> cardResponseDtos = cardService.filterLabel(boardId, filters);

    return ResponseEntity.ok()
        .body(ResponseDto.<CardListResDto>builder()
            .message("카드 라벨 필터에 성공하였습니다.")
            .data(new CardListResDto(cardResponseDtos))
            .build());
  }

}
