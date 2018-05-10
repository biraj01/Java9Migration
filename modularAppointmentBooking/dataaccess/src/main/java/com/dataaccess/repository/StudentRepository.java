package com.dataaccess.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dataaccess.entities.StudentBean;

@Repository
public interface StudentRepository  extends  JpaRepository<StudentBean, Integer>{

	}
