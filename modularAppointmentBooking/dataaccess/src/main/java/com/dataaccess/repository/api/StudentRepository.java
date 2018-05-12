package com.dataaccess.repository.api;

import com.dataaccess.entities.StudentBean;

public interface StudentRepository {

	StudentBean findById(int studentId);

	StudentBean save(StudentBean student1);

	}
