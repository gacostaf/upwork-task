package com.upwork.task.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.upwork.task.TaskApplication;
import com.upwork.task.model.StudentProgram;

@SpringBootTest(classes = TaskApplication.class)
class StudentProgramServiceTest {
	@Autowired
	private StudentProgramService studentProgramService;
		
	@Test
	void listAllStudentProgram_success() {
		assertDoesNotThrow(() -> {
			List<StudentProgram> studentProgramsList = studentProgramService.listAllStudentProgram();
			assertNotNull(studentProgramsList);
		});
	}
	
	@Test
	void getStudentProgram_success() {
		assertDoesNotThrow(() -> {
			StudentProgram c = studentProgramService.getStudentProgram(1);
			assertNotNull(c);
		});
	}

	@Test
	void getStudentProgram_failure() {
		StudentProgram c = null;
		assertThrows(NoSuchElementException.class, () -> {
			studentProgramService.getStudentProgram(-1);	
		});
	}
	
	@Test
	void saveStudentProgram_success() {
		assertDoesNotThrow(() -> {
			StudentProgram c =  new StudentProgram(700, "1234567", "CE-BS", new Date());
			studentProgramService.saveStudentProgram(c);
		});
		
		assertDoesNotThrow(() -> {
			StudentProgram c = studentProgramService.getStudentProgram(700);
			assertNotNull(c);
		});
		
		//housecleaning
		assertDoesNotThrow(() -> {
			studentProgramService.deleteStudentProgram(700);
		});
		
		//test deletion success
		assertThrows(NoSuchElementException.class, () -> {
			studentProgramService.getStudentProgram(700);	
		});
	}
}
