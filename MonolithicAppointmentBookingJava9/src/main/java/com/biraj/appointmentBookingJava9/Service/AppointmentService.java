package com.biraj.appointmentBookingJava9.Service;

import java.util.List;

import com.biraj.appointmentBookingJava9.helper.AppointmentParameter;
import com.biraj.appointmentBookingJava9.model.AppointmentBean;



public interface AppointmentService {

	public void deleteAppointment(int appointmentId, int studentId);

	public AppointmentBean updateAppointment(int appointmentId, AppointmentParameter bean) throws Exception;

	public List<AppointmentBean> getallAppointments(int counselorId);

	public AppointmentBean createAppointment(AppointmentParameter bean) throws Exception;	
	

}
