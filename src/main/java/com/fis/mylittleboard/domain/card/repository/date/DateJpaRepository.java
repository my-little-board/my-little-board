package com.fis.mylittleboard.domain.card.repository.date;

import com.fis.mylittleboard.domain.card.entity.Date;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DateJpaRepository extends JpaRepository<Date, Long> {

  Optional<Date> findById(Long id);
}
