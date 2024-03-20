package com.fis.mylittleboard.domain.card.repository.cowork;

import com.fis.mylittleboard.domain.card.entity.Member;
import java.util.List;

public interface CoworkRepository {

	void save(Member member);

	List<Member> findByCardId(Long cardId);

	void delete(Member member);

}
