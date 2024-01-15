package com.upwork.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upwork.task.model.StudentCourse;
import com.upwork.task.repository.StudentCourseRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentCourseService {

	private StudentCourseRepository studentCourseRepository;
	
	private StudentCourseService() {
		//Private empty constructor
	}

	@Autowired
	public StudentCourseService(StudentCourseRepository cr) {
		this.studentCourseRepository = cr;
	}
	
	public List<StudentCourse> listAllStudentCourse() {
		return studentCourseRepository.findAll();
	}
	
	public StudentCourse getStudentCourse(Integer id) {
		return studentCourseRepository.findById(id).get();
	}
	
	public void saveStudentCourse(StudentCourse studentStudentCourse) {
		studentCourseRepository.save(studentStudentCourse);
	}
	
	public void deleteStudentCourse(Integer id) {
		studentCourseRepository.deleteById(id);
	}
} 
