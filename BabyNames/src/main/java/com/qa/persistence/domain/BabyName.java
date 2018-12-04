package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BabyName {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private int length;

	public BabyName() {

	}

	public BabyName(String name, int length) {
		this.name = name;
		this.length = length;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

}
