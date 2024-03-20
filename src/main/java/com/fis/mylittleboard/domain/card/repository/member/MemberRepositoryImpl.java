package com.fis.mylittleboard.domain.card.repository.member;

import com.fis.mylittleboard.domain.card.entity.Member;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {

  private final MemberJpaRepository memberJpaRepository;

  @Override
  public void save(Member member) {
    memberJpaRepository.save(member);
  }

  @Override
  public List<Member> findByCardId(Long cardId) {
    return memberJpaRepository.findByCardId(cardId);
  }

  @Override
  public void delete(Member member) {
    memberJpaRepository.delete(member);
  }

  @Override
  public Optional<Member> findById(Long id) {
    return memberJpaRepository.findById(id);
  }
}
