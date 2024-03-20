package com.fis.mylittleboard.domain.card.repository.cowork;

import com.fis.mylittleboard.domain.card.entity.CardMember;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CoworkRepositoryImpl implements CoworkRepository {

	private final CoworkJpaRepository coworkJpaRepository;

	@Override
	public void save(CardMember cardMember) {
		coworkJpaRepository.save(cardMember);
	}

	@Override
	public List<CardMember> findByCardId(Long cardId) {
		return coworkJpaRepository.findByCardId(cardId);
	}

	@Override
	public void delete(CardMember cardMember) {
		coworkJpaRepository.delete(cardMember);
	}
}
