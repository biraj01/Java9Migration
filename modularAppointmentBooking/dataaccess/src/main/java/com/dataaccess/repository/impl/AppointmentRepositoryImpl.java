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

	
	@Override
	public List<AppointmentBean> findAllAppointmentsByCounselorBean_CounselorId(int counselorId) {
	//	EntityManager entityManager = entityManagerFactory.createEntityManager();

//	    TypedQuery<AppointmentBean> query = entityManager.createQuery("SELECT book from BookEntity book where book.id = :id", AppointmentBean.class);
//	    query.setParameter("id", counselorId);
//	    return query.getSingleResult();
	    return null;
	}

	@Override
	public List<AppointmentBean> findAllAppointmentsByStudentBean_StudentId(int counselorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AppointmentBean findById(int appointmentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(int appointmentId) {
		// TODO Auto-generated method stub

	}

	@Override
	public AppointmentBean save(AppointmentBean beanFormDB) {
		System.out.println(entityManager + "isNUll?" );
		entityManager.persist(beanFormDB);

		return null;
	}

}
