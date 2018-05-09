package com.biraj.appointmentBookingJava9.Service;

import java.time.DateTimeException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biraj.appointmentBookingJava9.dao.AppointmentRepository;
import com.biraj.appointmentBookingJava9.dao.CounselorRepository;
import com.biraj.appointmentBookingJava9.dao.StudentRepository;
import com.biraj.appointmentBookingJava9.helper.AppointmentParameter;
import com.biraj.appointmentBookingJava9.model.AppointmentBean;
import com.biraj.appointmentBookingJava9.model.CounselorBean;
import com.biraj.appointmentBookingJava9.model.StudentBean;



@Service(value = "appointmentService")
public class AppointmentServiceImpl implements AppointmentService {

	private AppointmentRepository appointmentRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private CounselorRepository counselorRepository;

	@Autowired
	public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
		super();
		if(appointmentRepository == null) {
			System.out.println("sda");
		}
		this.appointmentRepository = appointmentRepository;
	}

	@Override
	public void deleteAppointment(int appointmentId, int studentId) {
	AppointmentBean bean = appointmentRepository.findById(appointmentId).get();
		if (bean.getStudentBean().getMatrikerNr() == studentId) {
			appointmentRepository.deleteById(appointmentId);
		} else {
			System.out.println("no right to delete");
		}

	}

	@Override
	public AppointmentBean updateAppointment(int appointmentId, AppointmentParameter bean) throws Exception {
		validateParam(bean);
		AppointmentBean beanFormDB = appointmentRepository.findById(appointmentId).get();
		if (beanFormDB == null) {
			throw new Exception("Appointment with appointmentId" + appointmentId + "not found");
		}
		CounselorBean counselorBean = counselorRepository.findById(bean.getCounselorId()).get();
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

		StudentBean studentBean = studentRepository.findById(param.getStudentId()).get();
		CounselorBean counselorBean = counselorRepository.findById(param.getCounselorId()).get();
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
