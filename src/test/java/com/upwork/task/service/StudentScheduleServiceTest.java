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
import com.upwork.task.model.StudentSchedule;

@SpringBootTest(classes = TaskApplication.class)
class StudentScheduleServiceTest {
	@Autowired
	private StudentScheduleService studentScheduleService;
		
	@Test
	void listAllStudentSchedule_success() {
		assertDoesNotThrow(() -> {
			List<StudentSchedule> studentSchedulesList = studentScheduleService.listAllStudentSchedule();
			assertNotNull(studentSchedulesList);
		});
	}
	
	@Test
	void getStudentSchedule_success() {
		assertDoesNotThrow(() -> {
			StudentSchedule c = studentScheduleService.getStudentSchedule(1);
			assertNotNull(c);
		});
	}

	@Test
	void getStudentSchedule_failure() {
		StudentSchedule c = null;
		assertThrows(NoSuchElementException.class, () -> {
			studentScheduleService.getStudentSchedule(-1);	
		});
	}
	
	@Test
	void saveStudentSchedule_success() {
		assertDoesNotThrow(() -> {
			StudentSchedule c =  new StudentSchedule(700, "1234567", "111", "CB-301", "111-01", new Date(), new Date());
			studentScheduleService.saveStudentSchedule(c);
		});
		
		assertDoesNotThrow(() -> {
			StudentSchedule c = studentScheduleService.getStudentSchedule(700);
			assertNotNull(c);
		});
		
		//housecleaning
		assertDoesNotThrow(() -> {
			studentScheduleService.deleteStudentSchedule(700);
		});
		
		//test deletion success
		assertThrows(NoSuchElementException.class, () -> {
			studentScheduleService.getStudentSchedule(700);	
		});
	}
}
