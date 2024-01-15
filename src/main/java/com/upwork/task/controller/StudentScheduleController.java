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

import com.upwork.task.model.StudentSchedule;
import com.upwork.task.service.StudentScheduleService;

@RestController
@RequestMapping("/student-schedule")
public class StudentScheduleController {
	@Autowired
	private StudentScheduleService studentScheduleService;
	
	@GetMapping("")
	public List<StudentSchedule> getStudentSchedules() {
		return studentScheduleService.listAllStudentSchedule();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<StudentSchedule> getStudentSchedule(@PathVariable Integer id) {
		try {
			StudentSchedule studentSchedule = studentScheduleService.getStudentSchedule(id);
			return new ResponseEntity<>(studentSchedule, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/")
	public ResponseEntity<StudentSchedule> saveStudentSchedule(@RequestBody StudentSchedule studentSchedule) {
		studentScheduleService.saveStudentSchedule(studentSchedule);
		return new ResponseEntity<>(studentSchedule, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<StudentSchedule> updateStudentSchedule(@PathVariable Integer id, 
										  @RequestBody StudentSchedule studentSchedule) {
		try {
			studentSchedule.setPkStudentSchedule(id);
			studentScheduleService.saveStudentSchedule(studentSchedule);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);			
		}
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteStudentSchedule(@PathVariable Integer id) {
		studentScheduleService.deleteStudentSchedule(id);
	}

}
