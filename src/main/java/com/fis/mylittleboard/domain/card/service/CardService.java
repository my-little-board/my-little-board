package com.fis.mylittleboard.domain.card.service;

import com.fis.mylittleboard.domain.card.dto.CardColorResponseDto;
import com.fis.mylittleboard.domain.card.dto.CardDatesRequestDto;
import com.fis.mylittleboard.domain.card.dto.CardDatesResDto;
import com.fis.mylittleboard.domain.card.dto.CardDescriptionResponseDto;
import com.fis.mylittleboard.domain.card.dto.CardNameRequestDto;
import com.fis.mylittleboard.domain.card.dto.CardResponseDto;
import com.fis.mylittleboard.domain.card.dto.MemberResDto;
import com.fis.mylittleboard.domain.label.dto.LabelResponseDto;
import java.util.List;

public interface CardService {

  void createCard(CardNameRequestDto cardNameRequestDto);


  void deleteCard(Long cardId);

  CardResponseDto getCard(Long cardId);

  CardDescriptionResponseDto updateDescription(Long cardId, String description);

  CardColorResponseDto updateColor(Long cardId, String color);

  CardDatesResDto addDate(Long cardId, CardDatesRequestDto cardDatesRequestDto);

  CardDatesResDto updateDate(Long dateId, CardDatesRequestDto cardDatesRequestDto);

  void deleteDate(Long cardDateId);

  MemberResDto addMember(Long cardId, String username);

  void deleteMember(Long memberId);

  LabelResponseDto addLabel(Long cardId, Long labelId);

  void deleteCardLabel(Long cardLabelId);

  List<CardResponseDto> filterLabel(Long boardId, List<Long> filters);
}
