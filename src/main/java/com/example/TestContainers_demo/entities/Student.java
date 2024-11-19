package com.example.TestContainers_demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {

	@Id
	private Long id;
	private String name;
	
	public Student(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Student() {

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

}
