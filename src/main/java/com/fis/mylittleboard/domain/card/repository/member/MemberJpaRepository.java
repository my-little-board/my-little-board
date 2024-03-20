package com.fis.mylittleboard.domain.card.repository.member;

import com.fis.mylittleboard.domain.card.entity.Member;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {

	List<Member> findByCardId(Long cardId);
}
