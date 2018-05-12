/**
 * 
 */
/**
 * @author biraj
 *
 */
module mainmodule {
	
	requires  dataaccess;
	requires appointmentService;
	
	uses com.appointmentService.api.AppointmentService;
	uses com.dataaccess.repository.api.CounselorRepository;
	uses com.dataaccess.repository.api.StudentRepository;
	uses com.dataaccess.repository.api.AppointmentRepository;

	requires spring.beans;
	requires spring.boot;
	requires spring.boot.autoconfigure;
	requires spring.context;
	requires spring.core;
	requires spring.web;

}