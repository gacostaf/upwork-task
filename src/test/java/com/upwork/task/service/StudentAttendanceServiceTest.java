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
import com.upwork.task.model.StudentAttendance;

@SpringBootTest(classes = TaskApplication.class)
class StudentAttendanceServiceTest {
	@Autowired
	private StudentAttendanceService studentAttendanceService;
		
	@Test
	void listAllStudentAttendance_success() {
		assertDoesNotThrow(() -> {
			List<StudentAttendance> studentAttendancesList = studentAttendanceService.listAllStudentAttendance();
			assertNotNull(studentAttendancesList);
		});
	}
	
	@Test
	void getStudentAttendance_success() {
		StudentAttendance ca =  new StudentAttendance(700, "1234567", "111", "CB-301", "111-01", new Date(), UUID.randomUUID().toString());
		studentAttendanceService.saveStudentAttendance(ca);
		assertDoesNotThrow(() -> {
			StudentAttendance c = studentAttendanceService.getStudentAttendance(700);
			assertNotNull(c);
		});
	}

	@Test
	void getStudentAttendance_failure() {
		StudentAttendance c = null;
		assertThrows(NoSuchElementException.class, () -> {
			studentAttendanceService.getStudentAttendance(-1);	
		});
	}
	
	@Test
	void saveStudentAttendance_success() {
		assertDoesNotThrow(() -> {
			StudentAttendance c =  new StudentAttendance(700, "1234567", "111", "CB-301", "111-01", new Date(), UUID.randomUUID().toString());
			studentAttendanceService.saveStudentAttendance(c);
		});
		
		assertDoesNotThrow(() -> {
			StudentAttendance c = studentAttendanceService.getStudentAttendance(700);
			assertNotNull(c);
		});
		
		//housecleaning
		assertDoesNotThrow(() -> {
			studentAttendanceService.deleteStudentAttendance(700);
		});
		
		//test deletion success
		assertThrows(NoSuchElementException.class, () -> {
			studentAttendanceService.getStudentAttendance(700);	
		});
	}
}
