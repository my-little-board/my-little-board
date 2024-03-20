package com.fis.mylittleboard.domain.card.repository.cardfunction;

import com.fis.mylittleboard.domain.card.entity.CardFunction;
import java.util.Optional;
import javax.swing.text.html.Option;

public interface CardFunctionRepository {


	void save(CardFunction cardFunction);

	Optional<CardFunction> findById(Long id);

	void delete(CardFunction cardFunction);
}
