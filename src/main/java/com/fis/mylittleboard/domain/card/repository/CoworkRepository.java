package com.fis.mylittleboard.domain.card.repository;

import com.fis.mylittleboard.domain.card.entity.Cowork;
import java.util.List;

public interface CoworkRepository {

	void save(Cowork cowork);

	List<Cowork> findByCardId(Long cardId);

	void delete(Cowork cowork);

}
