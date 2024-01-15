package com.upwork.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upwork.task.model.StudentSchedule;
import com.upwork.task.repository.StudentScheduleRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentScheduleService {

	private StudentScheduleRepository studentScheduleRepository;
	
//	public StudentScheduleService() {
//		//Private empty constructor
//	}
//
//	@Autowired
//	public StudentScheduleService(StudentScheduleRepository cr) {
//		this.studentScheduleRepository = cr;
//	}
	
	public List<StudentSchedule> listAllStudentSchedule() {
		return studentScheduleRepository.findAll();
	}
	
	public StudentSchedule getStudentSchedule(Integer id) {
		return studentScheduleRepository.findById(id).get();
	}
	
	public void saveStudentSchedule(StudentSchedule studentSchedule) {
		studentScheduleRepository.save(studentSchedule);
	}
	
	public void deleteStudentSchedule(Integer id) {
		studentScheduleRepository.deleteById(id);
	}
} 
