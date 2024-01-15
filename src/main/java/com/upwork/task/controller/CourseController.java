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

import com.upwork.task.model.Course;
import com.upwork.task.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	@GetMapping("")
	public List<Course> getCourses() {
		return courseService.listAllCourse();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Course> getCourse(@PathVariable Integer id) {
		try {
			Course course = courseService.getCourse(id);
			return new ResponseEntity<Course>(course, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/")
	public ResponseEntity<?> saveCourse(@RequestBody Course course) {
		courseService.saveCourse(course);
		return new ResponseEntity<>(course, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateCourse(@PathVariable Integer id, 
										  @RequestBody Course course) {
		try {
			course.setPkCourse(id);
			courseService.saveCourse(course);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);			
		}
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteCourse(@PathVariable Integer id) {
		courseService.deleteCourse(id);
	}

}
