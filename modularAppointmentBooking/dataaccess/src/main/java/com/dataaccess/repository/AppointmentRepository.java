package com.dataaccess.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dataaccess.entities.AppointmentBean;

	@Repository
	public interface AppointmentRepository extends JpaRepository<AppointmentBean, Integer>  {
		List<AppointmentBean> findAllAppointmentsByCounselorBean_CounselorId(int counselorId);
		List<AppointmentBean> findAllAppointmentsByStudentBean_StudentId(int counselorId);
		
	}