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
import com.upwork.task.model.StudentCourse;

@SpringBootTest(classes = TaskApplication.class)
class StudentCourseServiceTest {
	@Autowired
	private StudentCourseService studentCourseService;
		
	@Test
	void listAllStudentCourse_success() {
		assertDoesNotThrow(() -> {
			List<StudentCourse> studentCoursesList = studentCourseService.listAllStudentCourse();
			assertNotNull(studentCoursesList);
		});
	}
	
	@Test
	void getStudentCourse_success() {
		assertDoesNotThrow(() -> {
			StudentCourse c = studentCourseService.getStudentCourse(1);
			assertNotNull(c);
		});
	}

	@Test
	void getStudentCourse_failure() {
		StudentCourse c = null;
		assertThrows(NoSuchElementException.class, () -> {
			studentCourseService.getStudentCourse(-1);	
		});
	}
	
	@Test
	void saveStudentCourse_success() {
		assertDoesNotThrow(() -> {
			StudentCourse c =  new StudentCourse(700, "1234567", "111", new Date());
			studentCourseService.saveStudentCourse(c);
		});
		
		assertDoesNotThrow(() -> {
			StudentCourse c = studentCourseService.getStudentCourse(700);
			assertNotNull(c);
		});
		
		//housecleaning
		assertDoesNotThrow(() -> {
			studentCourseService.deleteStudentCourse(700);
		});
		
		//test deletion success
		assertThrows(NoSuchElementException.class, () -> {
			studentCourseService.getStudentCourse(700);	
		});
	}
}
