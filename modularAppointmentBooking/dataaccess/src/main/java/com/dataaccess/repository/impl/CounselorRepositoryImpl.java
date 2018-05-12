package com.dataaccess.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dataaccess.entities.CounselorBean;
import com.dataaccess.repository.api.CounselorRepository;

@Service(value = "counselorRepository")
@Transactional
public class CounselorRepositoryImpl implements CounselorRepository {


	@PersistenceContext	
	private EntityManager entityManager;	
	
	@Override
	public CounselorBean findById(int counselorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CounselorBean save(CounselorBean counselor) {
		entityManager.persist(counselor);
		return null;
	}

}
