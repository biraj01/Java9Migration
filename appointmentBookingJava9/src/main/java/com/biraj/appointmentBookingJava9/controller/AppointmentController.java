package com.biraj.appointmentBookingJava9.controller;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.biraj.appointmentBookingJava9.Service.AppointmentService;
import com.biraj.appointmentBookingJava9.helper.AppointmentParameter;
import com.biraj.appointmentBookingJava9.helper.AppointmentUrl;
import com.biraj.appointmentBookingJava9.model.AppointmentBean;



@RestController
public class AppointmentController {
	
	@Autowired
	private AppointmentService appointmentService;

	/**
	 * Erzeugt eine neue Beratungtermin
	 */
	@RequestMapping(value = AppointmentUrl.createAppointment, method = RequestMethod.POST)
	public ResponseEntity<?> createAppointment(@PathVariable String studentId, @RequestBody AppointmentParameter appointParam,
			BindingResult binding) {
		if(binding.hasErrors()){
			return new ResponseEntity<String>("Parameter binding Error",HttpStatus.NOT_ACCEPTABLE);
		}
		try {
			AppointmentBean bean = appointmentService.createAppointment(appointParam);
			return new ResponseEntity<AppointmentBean>(bean, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Löscht bereits angelegte Beratungtermin.
	 * 
	 * @param appointmentId
	 *            Id der Termin
	 */
	@RequestMapping(value = AppointmentUrl.deleteAppointment, method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteAppointment(@PathVariable int appointmentId, @PathVariable int studentId) {
		appointmentService.deleteAppointment(appointmentId,studentId );
	}

	/**
	 * Ändert bereits angelegte Termin.
	 * 
	 * @param appointmentId
	 *            Id det Termin
	 * @return AppointmentBean
	 */
	@RequestMapping(value = AppointmentUrl.updateAppoitnment, method = RequestMethod.PUT)
	public ResponseEntity<?> updateAppointment(@PathVariable int counselorId, @PathVariable int appointmentId,@RequestBody AppointmentParameter param) {
		try {
			AppointmentBean bean = appointmentService.updateAppointment(appointmentId,param);
			return new ResponseEntity<AppointmentBean>(bean, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Listet alle BeratungTermin an einem Tag
	 * 
	 * @return List<AppointmentBean>
	 */
	@RequestMapping(value = AppointmentUrl.listAppointments, method = RequestMethod.GET)
	public List<AppointmentBean> listAppointments(@PathVariable int counselorId) {
		return appointmentService.getallAppointments(counselorId);
	}
	
	
	
	@RequestMapping(value = "date", method = RequestMethod.GET)
	public LocalDateTime testDate() {
		return  LocalDateTime.now();
	}
	
	

}
