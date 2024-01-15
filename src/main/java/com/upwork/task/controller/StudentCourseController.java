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

import com.upwork.task.model.StudentCourse;
import com.upwork.task.service.StudentCourseService;

@RestController
@RequestMapping("/student-course")
public class StudentCourseController {
	@Autowired
	private StudentCourseService studentCourseService;
	
	@GetMapping("")
	public List<StudentCourse> getStudentCourses() {
		return studentCourseService.listAllStudentCourse();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<StudentCourse> getStudentCourse(@PathVariable Integer id) {
		try {
			StudentCourse studentCourse = studentCourseService.getStudentCourse(id);
			return new ResponseEntity<>(studentCourse, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/")
	public ResponseEntity<StudentCourse> saveStudentCourse(@RequestBody StudentCourse studentCourse) {
		studentCourseService.saveStudentCourse(studentCourse);
		return new ResponseEntity<>(studentCourse, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<StudentCourse> updateStudentCourse(@PathVariable Integer id, 
										  @RequestBody StudentCourse studentCourse) {
		try {
			studentCourse.setPkStudentCourse(id);
			studentCourseService.saveStudentCourse(studentCourse);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);			
		}
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteStudentCourse(@PathVariable Integer id) {
		studentCourseService.deleteStudentCourse(id);
	}

}
