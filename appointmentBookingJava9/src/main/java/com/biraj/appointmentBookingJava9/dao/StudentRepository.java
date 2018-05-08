package com.biraj.appointmentBookingJava9.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biraj.appointmentBookingJava9.model.StudentBean;


@Repository
public interface StudentRepository  extends JpaRepository<StudentBean, Integer>{

}
