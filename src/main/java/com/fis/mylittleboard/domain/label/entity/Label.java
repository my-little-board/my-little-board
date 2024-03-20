package com.fis.mylittleboard.domain.label.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "labels")
public class Label {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	@Column
	private String title;

	@Column(nullable = false)
	private String color;

	public Label(String title, String color) {
		this.title = title;
		this.color = color;
	}

	public void updateLabel(String title, String color) {
		this.title = title;
		this.color = color;
	}

}
