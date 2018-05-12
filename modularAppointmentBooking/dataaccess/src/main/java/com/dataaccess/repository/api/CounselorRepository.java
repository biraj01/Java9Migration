package com.dataaccess.repository.api;

import org.springframework.stereotype.Repository;

import com.dataaccess.entities.CounselorBean;

public interface CounselorRepository {

	CounselorBean findById(int counselorId);

	CounselorBean save(CounselorBean counselor);



}
