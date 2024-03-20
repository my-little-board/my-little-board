package com.fis.mylittleboard.domain.label.repository;

import com.fis.mylittleboard.domain.label.entity.Label;
import java.util.Optional;
import javax.swing.text.html.Option;

public interface LabelRepository {

	Label save(Label label);

	Optional<Label> findById(Long labelId);

	void delete(Label label);

}
