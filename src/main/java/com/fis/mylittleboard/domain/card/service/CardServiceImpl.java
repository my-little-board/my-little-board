package com.fis.mylittleboard.domain.card.service;

import com.fis.mylittleboard.domain.card.dto.CardColorResponseDto;
import com.fis.mylittleboard.domain.card.dto.CardDatesRequestDto;
import com.fis.mylittleboard.domain.card.dto.CardDatesResDto;
import com.fis.mylittleboard.domain.card.dto.CardDescriptionResponseDto;
import com.fis.mylittleboard.domain.card.dto.CardNameRequestDto;
import com.fis.mylittleboard.domain.card.dto.CardNameResDto;
import com.fis.mylittleboard.domain.card.dto.CardResponseDto;
import com.fis.mylittleboard.domain.card.dto.MemberResDto;
import com.fis.mylittleboard.domain.card.entity.Card;
import com.fis.mylittleboard.domain.card.entity.CardLabel;
import com.fis.mylittleboard.domain.card.entity.Date;
import com.fis.mylittleboard.domain.card.entity.Member;
import com.fis.mylittleboard.domain.card.repository.card.CardRepository;
import com.fis.mylittleboard.domain.card.repository.cardlabel.CardLabelRepository;
import com.fis.mylittleboard.domain.card.repository.date.DateRepository;
import com.fis.mylittleboard.domain.card.repository.member.MemberRepository;
import com.fis.mylittleboard.domain.label.dto.LabelResponseDto;
import com.fis.mylittleboard.domain.label.entity.Label;
import com.fis.mylittleboard.domain.label.repository.LabelRepository;
import com.fis.mylittleboard.domain.user.model.User;
import com.fis.mylittleboard.domain.user.repository.UserJpaRepository;
import com.fis.mylittleboard.domain.user.repository.UserRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

  private final CardRepository cardRepository;
  private final MemberRepository memberRepository;
  private final LabelRepository labelRepository;
  private final CardLabelRepository cardLabelRepository;
  private final DateRepository dateRepository;
  private final UserRepository userRepository;
  private final UserJpaRepository userJpaRepository;

  public Card findCard(Long cardId) {
    return cardRepository.findById(cardId)
        .orElseThrow(() -> new IllegalArgumentException("해당 카드가 존재하지 않습니다."));
  }

  @Transactional
  public CardNameResDto createCard(CardNameRequestDto cardNameRequestDto) {
    Card card = new Card(cardNameRequestDto);
    Card savedCard = cardRepository.save(card);
    return new CardNameResDto(savedCard.getName());
  }

  @Transactional
  public void deleteCard(Long cardId) {

    Card card = findCard(cardId);

    List<Member> works = memberRepository.findByCardId(cardId);
    works.forEach(memberRepository::delete);

    cardRepository.delete(card);
  }

  public CardResponseDto getCard(Long cardId) {
    Card card = findCard(cardId);

    List<Long> members = cardRepository.getMemberIds(cardId);
    List<Long> labels = cardRepository.getLabelIds(cardId);
    LocalDate dueDate = dateRepository.findByCardId(card.getId()).get().getDueDate();

    return new CardResponseDto(card, members, labels, dueDate);
  }

  @Transactional
  public CardDescriptionResponseDto updateDescription(Long cardId, String description) {
    Card card = findCard(cardId);

    card.updateDescription(description);
    return new CardDescriptionResponseDto(card);
  }

  @Transactional
  public CardColorResponseDto updateColor(Long cardId, String color) {
    Card card = findCard(cardId);

    card.updateColor(color);
    return new CardColorResponseDto(card);
  }

  @Transactional
  public CardDatesResDto addDate(
      Long cardId,
      CardDatesRequestDto cardDatesRequestDto) {
    Card card = findCard(cardId);

    Date date = new Date(card.getId(), cardDatesRequestDto.getDueDate());
    dateRepository.save(date);
    return new CardDatesResDto(date);
  }

  @Transactional
  public CardDatesResDto updateDate(
      Long dateId,
      CardDatesRequestDto cardDatesRequestDto) {

    Date date = dateRepository.findById(dateId)
        .orElseThrow(() -> new IllegalArgumentException("해당 date는 존재하지 않습니다."));

    date.updateDate(cardDatesRequestDto.getDueDate());
    return new CardDatesResDto(date);
  }

  @Transactional
  public void deleteDate(Long dateId) {
    Date date = dateRepository.findById(dateId)
        .orElseThrow(() -> new IllegalArgumentException("해당 date는 존재하지 않습니다."));
    dateRepository.delete(date);
  }

  @Transactional
  public MemberResDto addMember(Long cardId, String username) {
    Card card = findCard(cardId);

    User user = userRepository.findByUsername(username);

    Member member = new Member(card.getId(), user.getUsername());

    memberRepository.save(member);
    return new MemberResDto(member.getUsername());
  }

  @Transactional
  public void deleteMember(Long memberId) {
    Member member = memberRepository.findById(memberId)
        .orElseThrow(() -> new IllegalArgumentException("해당 카드에 존재하는 멤버가 아닙니다."));

    memberRepository.delete(member);
  }

  @Transactional
  public LabelResponseDto addLabel(Long cardId, Long labelId) {
    Card card = findCard(cardId);

    Label label = labelRepository.findById(labelId)
        .orElseThrow(() -> new IllegalArgumentException("해당 라벨이 존재하지 않습니다."));

    CardLabel cardLabel = new CardLabel(card.getId(), label.getId());

    cardLabelRepository.save(cardLabel);

    return new LabelResponseDto(label);
  }

  @Transactional
  public void deleteCardLabel(Long cardLabelId) {
    CardLabel cardLabel = cardLabelRepository.findById(cardLabelId)
        .orElseThrow(() -> new IllegalArgumentException("해당 카드 라벨이 존재하지 않습니다."));

    cardLabelRepository.delete(cardLabel);
  }

  @Transactional
  public List<CardResponseDto> filterLabel(Long boardId, List<Long> filters) {

    return filters.stream()
        .flatMap(l -> labelRepository.findByIds(boardId, l).stream())
        .flatMap(m -> cardLabelRepository.findByLabelId(m).stream())
        .map(this::getCard)
        .distinct()
        .collect(Collectors.toList());
  }

}
