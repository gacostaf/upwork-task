package com.upwork.task.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.NoSuchElementException;
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
	
	public StudentAttendance getStudentAttendance(Integer id) throws NoSuchElementException {
		Optional<StudentAttendance> optStudentAttendance = studentAttendanceRepository.findById(id);
		if (optStudentAttendance.isEmpty()) {
			throw new NoSuchElementException();
		} else {
			return optStudentAttendance.get();
		}	
	}
	
	public void saveStudentAttendance(StudentAttendance studentAttendance) {
		studentAttendanceRepository.save(studentAttendance);
	}
	
	public void deleteStudentAttendance(Integer id) {
		studentAttendanceRepository.deleteById(id);
	}
	
	public StudentAttendance findAttendanceByIdTransaction(String idTransaction) {
		return studentAttendanceRepository.findAttendanceByIdTransaction(idTransaction);
	}
} 
