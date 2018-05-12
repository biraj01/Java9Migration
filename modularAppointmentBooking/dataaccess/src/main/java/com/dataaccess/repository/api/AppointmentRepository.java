package com.dataaccess.repository.api;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dataaccess.entities.AppointmentBean;

	public interface AppointmentRepository {
		List<AppointmentBean> findAllAppointmentsByCounselorBean_CounselorId(int counselorId);
		List<AppointmentBean> findAllAppointmentsByStudentBean_StudentId(int counselorId);
		AppointmentBean findById(int appointmentId);
		void deleteById(int appointmentId);
		AppointmentBean save(AppointmentBean beanFormDB);
		
	}