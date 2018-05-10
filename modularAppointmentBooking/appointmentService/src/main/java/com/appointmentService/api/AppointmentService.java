package com.appointmentService.api;

import java.util.List;

import com.appointmentService.helper.AppointmentParameter;
import com.dataaccess.entities.AppointmentBean;

public interface AppointmentService {

	
	public void deleteAppointment(int appointmentId, int studentId);

	public AppointmentBean updateAppointment(int appointmentId, AppointmentParameter bean) throws Exception;

	public List<AppointmentBean> getallAppointments(int counselorId);

	public AppointmentBean createAppointment(AppointmentParameter bean) throws Exception;	
	
}
