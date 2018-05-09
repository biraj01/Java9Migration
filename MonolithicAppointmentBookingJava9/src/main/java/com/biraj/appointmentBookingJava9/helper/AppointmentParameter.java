package com.biraj.appointmentBookingJava9.helper;

import java.time.LocalDateTime;



public class AppointmentParameter {

	private int studentId;

	private int counselorId;

	private LocalDateTime from;


	private LocalDateTime to;



	public LocalDateTime getFrom() {
		return from;
	}


	public void setFrom(LocalDateTime from) {
		this.from = from;
	}

	public LocalDateTime getTo() {
		return to;
	}

	public void setTo(LocalDateTime to) {
		this.to = to;
	}

	
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getCounselorId() {
		return counselorId;
	}

	public void setCounselorId(int counselorId) {
		this.counselorId = counselorId;
	}

}
