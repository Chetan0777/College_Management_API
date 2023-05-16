package com.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.model.College;

@Repository
public interface CollegeRepository extends JpaRepository<College, Integer>{

}
