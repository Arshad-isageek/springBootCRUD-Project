package com.arshadvasg.springBootCRUDProject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="bu_students")
public class Student {
	
	@Id
	@Column
	private int roll_id;
	
	@Column
	private String name;
	
	@Column
	private String address;
	
	@Column
	private String graduated;
	
	public Student() {}

	public Student(int roll_id, String name, String address, String graduated) {
		super();
		this.roll_id = roll_id;
		this.name = name;
		this.address = address;
		this.graduated = graduated;
	}

	public int getRoll_id() {
		return roll_id;
	}

	public void setRoll_id(int roll_id) {
		this.roll_id = roll_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGraduated() {
		return graduated;
	}

	public void setGraduated(String graduated) {
		this.graduated = graduated;
	}

}
