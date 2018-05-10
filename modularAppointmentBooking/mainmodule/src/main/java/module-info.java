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

	requires spring.beans;
	requires spring.boot;
	requires spring.boot.autoconfigure;
	requires spring.context;
	requires spring.core;
	requires spring.web;
}