package com.upwork.task.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.upwork.task.TaskApplication;
import com.upwork.task.model.StudentTransaction;

@SpringBootTest(classes = TaskApplication.class)
class StudentTransactionServiceTest {
	@Autowired
	private StudentTransactionService studentTransactionService;
		
	@Test
	void listAllStudentTransaction_success() {
		assertDoesNotThrow(() -> {
			List<StudentTransaction> studentTransactionsList = studentTransactionService.listAllStudentTransaction();
			assertNotNull(studentTransactionsList);
		});
	}
	
	@Test
	void getStudentTransaction_success() {
		assertDoesNotThrow(() -> {
			StudentTransaction c = studentTransactionService.getStudentTransaction(1);
			assertNotNull(c);
		});
	}

	@Test
	void getStudentTransaction_failure() {
		StudentTransaction c = null;
		assertThrows(NoSuchElementException.class, () -> {
			studentTransactionService.getStudentTransaction(-1);	
		});
	}
	
	@Test
	void saveStudentTransaction_success() {
		assertDoesNotThrow(() -> {
			StudentTransaction c =  new StudentTransaction(700, UUID.randomUUID().toString(), "1234567", new Date());
			studentTransactionService.saveStudentTransaction(c);
		});
		
		assertDoesNotThrow(() -> {
			StudentTransaction c = studentTransactionService.getStudentTransaction(700);
			assertNotNull(c);
		});
		
		//housecleaning
		assertDoesNotThrow(() -> {
			studentTransactionService.deleteStudentTransaction(700);
		});
		
		//test deletion success
		assertThrows(NoSuchElementException.class, () -> {
			studentTransactionService.getStudentTransaction(700);	
		});
	}
}
