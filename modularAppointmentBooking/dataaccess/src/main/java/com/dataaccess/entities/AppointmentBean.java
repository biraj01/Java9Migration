package com.dataaccess.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(uniqueConstraints={
	    @UniqueConstraint(columnNames = {"student_id", "BEGIN"}),
	    @UniqueConstraint(columnNames={"counselor_id", "BEGIN"})
}) 
@Service
public class AppointmentBean {

	@Id
	@GeneratedValue
	private int appointmentId;
	
	@ManyToOne
	@JoinColumn(name="student_id")
	@JsonIgnore
	private StudentBean studentBean;

	@ManyToOne
	@JoinColumn(name="counselor_id")
	@JsonIgnore
	private CounselorBean counselorBean;
	

	@Column(name = "BEGIN")
	private LocalDateTime from;

	@Column(name = "END")
	private LocalDateTime to;
	
	public StudentBean getStudentBean() {
		return studentBean;
	}

	public void setStudentBean(StudentBean studentBean) {
		this.studentBean = studentBean;
	}

	public CounselorBean getCounselorBean() {
		return counselorBean;
	}

	public void setCounselorBean(CounselorBean counselorBean) {
		this.counselorBean = counselorBean;
	}


	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	
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
}



