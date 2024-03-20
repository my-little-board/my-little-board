package com.fis.mylittleboard.domain.card.repository.cowork;

import com.fis.mylittleboard.domain.card.entity.Member;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CoworkRepositoryImpl implements CoworkRepository {

	private final CoworkJpaRepository coworkJpaRepository;

	@Override
	public void save(Member member) {
		coworkJpaRepository.save(member);
	}

	@Override
	public List<Member> findByCardId(Long cardId) {
		return coworkJpaRepository.findByCardId(cardId);
	}

	@Override
	public void delete(Member member) {
		coworkJpaRepository.delete(member);
	}
}
