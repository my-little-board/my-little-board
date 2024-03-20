package com.fis.mylittleboard.domain.card.repository.member;

import com.fis.mylittleboard.domain.card.entity.Member;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {

	void save(Member member);

	List<Member> findByCardId(Long cardId);

	void delete(Member member);

	Optional<Member> findById(Long id);

}
