package com.appointmentService.impl;

import java.time.DateTimeException;
import java.util.List;
import java.util.ServiceLoader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appointmentService.api.AppointmentService;
import com.appointmentService.helper.AppointmentParameter;
import com.dataaccess.entities.AppointmentBean;
import com.dataaccess.entities.CounselorBean;
import com.dataaccess.entities.StudentBean;
import com.dataaccess.repository.api.AppointmentRepository;
import com.dataaccess.repository.api.CounselorRepository;
import com.dataaccess.repository.api.StudentRepository;


@Service(value = "appointmentService")
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private CounselorRepository counselorRepository;

	@Autowired
	private AppointmentRepository appointmentRepository;

	

	@Override
	public void deleteAppointment(int appointmentId, int studentId) {
		System.out.println("in delete appointment");
	AppointmentBean bean = appointmentRepository.findById(appointmentId);
	System.out.println(bean + "must be null");
		if (bean.getStudentBean().getMatrikerNr() == studentId) {
			appointmentRepository.deleteById(appointmentId);
		} else {
			System.out.println("no right to delete");
		}

	}

	@Override
	public AppointmentBean updateAppointment(int appointmentId, AppointmentParameter bean) throws Exception {
		validateParam(bean);
		AppointmentBean beanFormDB = appointmentRepository.findById(appointmentId);
		if (beanFormDB == null) {
			throw new Exception("Appointment with appointmentId" + appointmentId + "not found");
		}
		CounselorBean counselorBean = counselorRepository.findById(bean.getCounselorId());
		if (bean.getFrom().getHour() < counselorBean.getOpenFrom().getHour()) {
			// Throw closed hour exception
			throw new DateTimeException("Counselor office is closed");
		}
		beanFormDB.setFrom(bean.getFrom());
		beanFormDB.setTo(bean.getTo());
		return appointmentRepository.save(beanFormDB);
	}

	@Override
	public List<AppointmentBean> getallAppointments(int counselorId) {
		return appointmentRepository.findAllAppointmentsByCounselorBean_CounselorId(counselorId);
	}

	@Override
	public AppointmentBean createAppointment(AppointmentParameter param) throws Exception {

		validateParam(param);

		AppointmentBean bean = new AppointmentBean();
		bean.setFrom(param.getFrom());
		bean.setTo(param.getTo());

		StudentBean studentBean = studentRepository.findById(param.getStudentId());
		CounselorBean counselorBean = counselorRepository.findById(param.getCounselorId());
		if (studentBean == null) {
			throw new Exception("student with studentId" + param.getStudentId() + " is not found"); 
		}
		if(counselorBean == null){
			throw new  Exception("Counselor with counselorId" + param.getCounselorId() + " is not found");
		}
		bean.setCounselorBean(counselorBean);
		bean.setStudentBean(studentBean);
		if (bean.getFrom().getHour() < counselorBean.getOpenFrom().getHour()) {
			// Throw closed hour exception
			throw new DateTimeException("Closed hours");
		}
		return appointmentRepository.save(bean);
	}

	private void validateParam(AppointmentParameter param) {

		if (param.getFrom().isAfter(param.getTo())) {
			throw new DateTimeException("Date from and to not valid");
		}
		if (param.getFrom().getMinute() > 0 || param.getTo().getMinute() > 0) {
			throw new DateTimeException("Time should be rounded off to hours");
		}
		if (param.getTo().isAfter(param.getFrom().plusHours(1))) {
			throw new DateTimeException("Appointment is fixed for max 1 Hour");
		}

	}

}
