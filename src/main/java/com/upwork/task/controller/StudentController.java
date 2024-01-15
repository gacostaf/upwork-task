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

import com.upwork.task.model.Student;
import com.upwork.task.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@GetMapping("")
	public List<Student> getStudents() {
		return studentService.listAllStudent();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable Integer id) {
		try {
			Student student = studentService.getStudent(id);
			return new ResponseEntity<Student>(student, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/")
	public void saveStudent(@RequestBody Student student) {
		studentService.saveStudent(student);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateStudent(@PathVariable Integer id, 
										  @RequestBody Student student) {
		try {
			Student originalUser = studentService.getStudent(id);
			student.setPkStudent(id);
			studentService.saveStudent(student);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);			
		}
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable Integer id) {
		studentService.deleteStudent(id);
	}

}
