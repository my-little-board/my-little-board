package com.fis.mylittleboard.domain.card.repository.date;

import com.fis.mylittleboard.domain.card.entity.Date;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DateRepositoryImpl implements DateRepository{

	private final DateJpaRepository dateJpaRepository;

	@Override
	public void save(Date date) {
		dateJpaRepository.save(date);
	}

	@Override
	public Optional<Date> findById(Long id) {
		return dateJpaRepository.findById(id);
	}

	@Override
	public void delete(Date date) {
		dateJpaRepository.delete(date);
	}
}
