package com.college.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.exception.CollegeException;
import com.college.model.College;

@Repository
public interface CollegeRepository extends JpaRepository<College, Integer>{

	List<College> findByCourseName(String courseName) throws CollegeException;

}
