package com.upwork.task.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upwork.task.model.StudentAttendance;
import com.upwork.task.service.StudentAttendanceService;

@RestController
@RequestMapping("/student-attendance")
public class StudentAttendanceController {
	@Autowired
	private StudentAttendanceService studentAttendanceService;
	
	@GetMapping("")
	public List<StudentAttendance> getStudentAttendances() {
		return studentAttendanceService.listAllStudentAttendance();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<StudentAttendance> getStudentAttendance(@PathVariable Integer id) {
		try {
			StudentAttendance studentAttendance = studentAttendanceService.getStudentAttendance(id);
			return new ResponseEntity<>(studentAttendance, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/")
	public ResponseEntity<StudentAttendance> saveStudentAttendance(@RequestBody StudentAttendance studentAttendance) {
		studentAttendanceService.saveStudentAttendance(studentAttendance);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<StudentAttendance> updateStudentAttendance(@PathVariable Integer id, 
										  @RequestBody StudentAttendance studentAttendance) {
		try {
			studentAttendance.setPkStudentAttendance(id);
			studentAttendanceService.saveStudentAttendance(studentAttendance);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);			
		}
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteStudentAttendance(@PathVariable Integer id) {
		studentAttendanceService.deleteStudentAttendance(id);
	}

}
