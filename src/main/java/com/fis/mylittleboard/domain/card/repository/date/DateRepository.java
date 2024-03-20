package com.fis.mylittleboard.domain.card.repository.date;

import com.fis.mylittleboard.domain.card.entity.Date;
import java.util.Optional;

public interface DateRepository {

	Optional<Date> findById(Long id);

	void delete(Date date);
}
