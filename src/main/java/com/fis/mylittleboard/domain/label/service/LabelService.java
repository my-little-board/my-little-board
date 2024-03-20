package com.fis.mylittleboard.domain.label.service;

public interface LabelService {

	void createLabel(String label, String color);

	void deleteLabel(Long labelId);
}
