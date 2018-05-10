package com.dataaccess.entities;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class CounselorBean {
	
	private String firstName;
	
	private String lastName;
	
	@Id
	@GeneratedValue
	@Column(name="counselor_id")
	private int counselorId;
	
	private LocalTime openFrom;
	
	private LocalTime openTill;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getId() {
		return counselorId;
	}

	public void setId(int counselorId) {
		this.counselorId = counselorId;
	}

	public LocalTime getOpenFrom() {
		return openFrom;
	}

	public void setOpenFrom(LocalTime openFrom) {
		this.openFrom = openFrom;
	}

	public LocalTime getOpenTill() {
		return openTill;
	}

	public void setOpenTill(LocalTime openTill) {
		this.openTill = openTill;
	}
	
	
}
