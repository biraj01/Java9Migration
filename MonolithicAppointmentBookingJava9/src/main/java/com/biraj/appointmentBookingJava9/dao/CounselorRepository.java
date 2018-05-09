package com.biraj.appointmentBookingJava9.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biraj.appointmentBookingJava9.model.CounselorBean;


@Repository
public interface CounselorRepository extends JpaRepository<CounselorBean, Integer> {

}
