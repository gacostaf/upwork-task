package com.upwork.task.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

import com.upwork.task.model.Course;
import com.upwork.task.repository.CourseRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	public CourseService() {
		//Empty constructor for testing purposes
		
	}

	public List<Course> listAllCourse() {
		return courseRepository.findAll();
	}
	
	public Course getCourse(Integer id) throws NoSuchElementException {
		Optional<Course> optCourse = courseRepository.findById(id);
		if (optCourse.isEmpty()) {
			throw new NoSuchElementException();
		} else {
			return optCourse.get();
		}
	}
	
	public void saveCourse(Course course) {
		courseRepository.save(course);
	}
	
	public void deleteCourse(Integer id) {
		courseRepository.deleteById(id);
	}
} 
