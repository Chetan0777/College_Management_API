package com.college.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.model.College;
import com.college.repository.CollegeRepository;

@RestController
@RequestMapping("/colleges")
public class CollegeController {

	@Autowired
	CollegeRepository collegeRepository;
	
	
	@PostMapping("/save")
    public ResponseEntity<String> createCollege(@RequestBody College college) {
        collegeRepository.save(college);
        return ResponseEntity.ok("College details saved successfully....");
    }
	
}
