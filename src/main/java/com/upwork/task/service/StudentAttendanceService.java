package com.upwork.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upwork.task.model.StudentAttendance;
import com.upwork.task.repository.StudentAttendanceRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentAttendanceService {

	private StudentAttendanceRepository studentAttendanceRepository;
	
	private StudentAttendanceService() {
		//Private empty constructor
	}

	@Autowired
	public StudentAttendanceService(StudentAttendanceRepository cr) {
		this.studentAttendanceRepository = cr;
	}
	
	public List<StudentAttendance> listAllStudentAttendance() {
		return studentAttendanceRepository.findAll();
	}
	
	public StudentAttendance getStudentAttendance(Integer id) {
		return studentAttendanceRepository.findById(id).get();
	}
	
	public void saveStudentAttendance(StudentAttendance studentAttendance) {
		studentAttendanceRepository.save(studentAttendance);
	}
	
	public void deleteStudentAttendance(Integer id) {
		studentAttendanceRepository.deleteById(id);
	}
} 
