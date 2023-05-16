package com.college.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.exception.CollegeException;
import com.college.model.College;
import com.college.repository.CollegeRepository;

@RestController
@RequestMapping("/colleges")
public class CollegeController {

	@Autowired
	CollegeRepository collegeRepository;
	
	//API to save College with all Details
	
	@PostMapping("/create")
    public ResponseEntity<String> createCollege(@RequestBody College college) throws CollegeException {
        
		collegeRepository.save(college);
        return ResponseEntity.ok("College details saved successfully....");
    
	}
	
	
	//API to get the List of College with all Details 
	
	@GetMapping("/listOfColleges")
    public ResponseEntity<List<College>> getAllColleges() {
		
        return new  ResponseEntity<List<College>> (collegeRepository.findAll(),HttpStatus.OK);
    
	}
	
	//API to get the College details with Course Name 
	
	@GetMapping("collegeByCourse/{courseName}")
    public ResponseEntity<List<College>> getCollegeByCourseName(@PathVariable String courseName) throws CollegeException {
		
		return new ResponseEntity<List<College>>(collegeRepository.findByCourseName(courseName),HttpStatus.OK);
        
    }
	
}
