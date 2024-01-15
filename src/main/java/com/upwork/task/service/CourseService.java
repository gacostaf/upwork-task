package com.upwork.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upwork.task.model.Course;
import com.upwork.task.repository.CourseRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CourseService {

	private CourseRepository courseRepository;
	
	private CourseService() {
		//Private empty constructor
	}

	@Autowired
	public CourseService(CourseRepository cr) {
		this.courseRepository = cr;
	}
	
	public List<Course> listAllCourse() {
		return courseRepository.findAll();
	}
	
	public Course getCourse(Integer id) {
		return courseRepository.findById(id).get();
	}
	
	public void saveCourse(Course course) {
		courseRepository.save(course);
	}
	
	public void deleteCourse(Integer id) {
		courseRepository.deleteById(id);
	}
} 
