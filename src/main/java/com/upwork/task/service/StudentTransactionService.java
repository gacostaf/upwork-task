package com.upwork.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upwork.task.model.StudentTransaction;
import com.upwork.task.repository.StudentTransactionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentTransactionService {

	private StudentTransactionRepository studentTransactionRepository;
	
	private StudentTransactionService() {
		//Private empty constructor
	}

	@Autowired
	public StudentTransactionService(StudentTransactionRepository cr) {
		this.studentTransactionRepository = cr;
	}
	
	public List<StudentTransaction> listAllStudentTransaction() {
		return studentTransactionRepository.findAll();
	}
	
	public StudentTransaction getStudentTransaction(Integer id) {
		return studentTransactionRepository.findById(id).get();
	}
	
	public void saveStudentTransaction(StudentTransaction studentTransaction) {
		studentTransactionRepository.save(studentTransaction);
	}
	
	public void deleteStudentTransaction(Integer id) {
		studentTransactionRepository.deleteById(id);
	}
} 
