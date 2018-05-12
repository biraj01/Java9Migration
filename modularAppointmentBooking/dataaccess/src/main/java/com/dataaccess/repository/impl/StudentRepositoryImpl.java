package com.dataaccess.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dataaccess.entities.StudentBean;
import com.dataaccess.repository.api.StudentRepository;

@Service(value = "studentRepository")
@Transactional
public class StudentRepositoryImpl implements StudentRepository {


	@PersistenceContext	
	private EntityManager entityManager;	
	
	@Override
	public StudentBean findById(int studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentBean save(StudentBean student1) {
		entityManager.persist(student1);
		return null;
	}

}
