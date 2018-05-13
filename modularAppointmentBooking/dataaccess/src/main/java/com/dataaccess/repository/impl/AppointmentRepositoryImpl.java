package com.dataaccess.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.dataaccess.entities.AppointmentBean;
import com.dataaccess.repository.api.AppointmentRepository;

@Service(value = "appointmentRepository")
@org.springframework.transaction.annotation.Transactional
public class AppointmentRepositoryImpl implements AppointmentRepository {

	@PersistenceContext	
	private EntityManager entityManager;	

	@SuppressWarnings("unchecked")
	@Override
	public List<AppointmentBean> findAllAppointmentsByCounselorBean_CounselorId(int counselorId) {
		List<AppointmentBean> appointmentList =  
		entityManager.createQuery("from AppointmentBean c WHERE c.counselorBean.counselor_id LIKE :id")
	    .setParameter("id", counselorId)
	    .getResultList();
	    return appointmentList ;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AppointmentBean> findAllAppointmentsByStudentBean_StudentId(int studentId) {
		List<AppointmentBean> appointmentList =  
				entityManager.createQuery("from AppointmentBean c WHERE c.studentBean.studentId LIKE :id")
			    .setParameter("id", studentId)
			    .getResultList();
			    return appointmentList ;
	}

	@Override
	public AppointmentBean findById(int appointmentId) {
		return entityManager.find(AppointmentBean.class, appointmentId);
	}

	@Override
	public void deleteById(int appointmentId) {
		AppointmentBean bean = entityManager.find(AppointmentBean.class, appointmentId);
		entityManager.detach(bean);

	}

	@Override
	public AppointmentBean save(AppointmentBean bean) {
		entityManager.persist(bean);
		return bean;
	}

}
