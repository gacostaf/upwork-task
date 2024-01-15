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

import com.upwork.task.model.StudentTransaction;
import com.upwork.task.service.StudentTransactionService;

@RestController
@RequestMapping("/student-transaction")
public class StudentTransactionController {
	@Autowired
	private StudentTransactionService studentTransactionService;
	
	@GetMapping("")
	public List<StudentTransaction> getStudentTransactions() {
		return studentTransactionService.listAllStudentTransaction();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<StudentTransaction> getStudentTransaction(@PathVariable Integer id) {
		try {
			StudentTransaction studentTransaction = studentTransactionService.getStudentTransaction(id);
			return new ResponseEntity<StudentTransaction>(studentTransaction, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<StudentTransaction>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/")
	public void saveStudentTransaction(@RequestBody StudentTransaction studentTransaction) {
		studentTransactionService.saveStudentTransaction(studentTransaction);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateStudentTransaction(@PathVariable Integer id, 
										  @RequestBody StudentTransaction studentTransaction) {
		try {
			StudentTransaction originalUser = studentTransactionService.getStudentTransaction(id);
			studentTransaction.setPkStudentTransaction(id);
			studentTransactionService.saveStudentTransaction(studentTransaction);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<StudentTransaction>(HttpStatus.NOT_FOUND);			
		}
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteStudentTransaction(@PathVariable Integer id) {
		studentTransactionService.deleteStudentTransaction(id);
	}

}
