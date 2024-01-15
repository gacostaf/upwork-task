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

import com.upwork.task.model.StudentProgram;
import com.upwork.task.service.StudentProgramService;

@RestController
@RequestMapping("/student-program")
public class StudentProgramController {
	@Autowired
	private StudentProgramService studentProgramService;
	
	@GetMapping("")
	public List<StudentProgram> getStudentPrograms() {
		return studentProgramService.listAllStudentProgram();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<StudentProgram> getStudentProgram(@PathVariable Integer id) {
		try {
			StudentProgram studentProgram = studentProgramService.getStudentProgram(id);
			return new ResponseEntity<StudentProgram>(studentProgram, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<StudentProgram>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/")
	public void saveStudentProgram(@RequestBody StudentProgram studentProgram) {
		studentProgramService.saveStudentProgram(studentProgram);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateStudentProgram(@PathVariable Integer id, 
										  @RequestBody StudentProgram studentProgram) {
		try {
			StudentProgram originalUser = studentProgramService.getStudentProgram(id);
			studentProgram.setPkStudentProgram(id);
			studentProgramService.saveStudentProgram(studentProgram);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<StudentProgram>(HttpStatus.NOT_FOUND);			
		}
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteStudentProgram(@PathVariable Integer id) {
		studentProgramService.deleteStudentProgram(id);
	}

}
