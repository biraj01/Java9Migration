package com.dataaccess.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dataaccess.entities.CounselorBean;

@Repository
public interface CounselorRepository extends JpaRepository<CounselorBean, Integer> {



}
