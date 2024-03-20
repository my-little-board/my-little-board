package com.fis.mylittleboard.domain.label.repository;

import com.fis.mylittleboard.domain.label.entity.Label;
import java.util.Optional;

public interface LabelRepository {

  Label save(Label label);

  Optional<Label> findById(Long labelId);

  void delete(Label label);

}
