package com.upwork.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upwork.task.model.StudentProgram;
import com.upwork.task.repository.StudentProgramRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentProgramService {

	private StudentProgramRepository studentProgramRepository;
	
	private StudentProgramService() {
		//Private empty constructor
	}

	@Autowired
	public StudentProgramService(StudentProgramRepository cr) {
		this.studentProgramRepository = cr;
	}
	
	public List<StudentProgram> listAllStudentProgram() {
		return studentProgramRepository.findAll();
	}
	
	public StudentProgram getStudentProgram(Integer id) {
		return studentProgramRepository.findById(id).get();
	}
	
	public void saveStudentProgram(StudentProgram studentProgram) {
		studentProgramRepository.save(studentProgram);
	}
	
	public void deleteStudentProgram(Integer id) {
		studentProgramRepository.deleteById(id);
	}
} 
