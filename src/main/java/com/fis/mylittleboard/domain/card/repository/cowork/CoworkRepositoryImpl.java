package com.fis.mylittleboard.domain.card.repository.cowork;

import com.fis.mylittleboard.domain.card.entity.Cowork;
import com.fis.mylittleboard.domain.card.repository.cowork.CoworkJpaRepository;
import com.fis.mylittleboard.domain.card.repository.cowork.CoworkRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CoworkRepositoryImpl implements CoworkRepository {

	private final CoworkJpaRepository coworkJpaRepository;

	@Override
	public void save(Cowork cowork) {
		coworkJpaRepository.save(cowork);
	}

	@Override
	public List<Cowork> findByCardId(Long cardId) {
		return coworkJpaRepository.findByCardId(cardId);
	}

	@Override
	public void delete(Cowork cowork) {
		coworkJpaRepository.delete(cowork);
	}
}
