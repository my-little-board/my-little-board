package com.fis.mylittleboard.domain.card.repository;

import com.fis.mylittleboard.domain.card.entity.Cowork;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
@RequiredArgsConstructor
public class CoworkRepositoryImpl implements CoworkRepository{

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
