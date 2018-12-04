package com.qa.persistence.domain;


public class BabyNameToSend {

	private Long id;
	private String name;
	private int length;

	public BabyNameToSend() {

	}

	public BabyNameToSend(Long id, String name, int length) {
		this.id = id;
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
