package com.biraj.appointmentBookingJava9.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.biraj.appointmentBookingJava9.model.AppointmentBean;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentBean, Integer>  {
    

	List<AppointmentBean> findAllAppointmentsByCounselorBean_CounselorId(int counselorId);
	
	
	List<AppointmentBean> findAllAppointmentsByStudentBean_StudentId(int counselorId);



}
