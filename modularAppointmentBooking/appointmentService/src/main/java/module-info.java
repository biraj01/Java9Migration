/**
 * @author biraj
 *
 */
module appointmentService {
	exports com.appointmentService.api;
	exports com.appointmentService.helper;
	exports com.appointmentService.impl;
	provides com.appointmentService.api.AppointmentService with com.appointmentService.impl.AppointmentServiceImpl;
	requires  dataaccess;
	requires spring.beans;
	requires spring.context;
	
	uses com.dataaccess.repository.api.AppointmentRepository;
	uses com.dataaccess.repository.api.CounselorRepository;
	uses com.dataaccess.repository.api.StudentRepository;

}