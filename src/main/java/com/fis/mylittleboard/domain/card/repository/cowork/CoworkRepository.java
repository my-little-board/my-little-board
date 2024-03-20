package com.fis.mylittleboard.domain.card.repository.cowork;

import com.fis.mylittleboard.domain.card.entity.CardMember;
import java.util.List;

public interface CoworkRepository {

	void save(CardMember cardMember);

	List<CardMember> findByCardId(Long cardId);

	void delete(CardMember cardMember);

}
