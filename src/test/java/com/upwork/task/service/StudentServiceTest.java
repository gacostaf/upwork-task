package com.upwork.task.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.upwork.task.TaskApplication;
import com.upwork.task.model.Student;

@SpringBootTest(classes = TaskApplication.class)
class StudentServiceTest {
	@Autowired
	private StudentService studentService;
		
	@Test
	void listAllStudent_success() {
		assertDoesNotThrow(() -> {
			List<Student> studentsList = studentService.listAllStudent();
			assertNotNull(studentsList);
		});
	}
	
	@Test
	void getStudent_success() {
		assertDoesNotThrow(() -> {
			Student c = studentService.getStudent(1);
			assertNotNull(c);
		});
	}

	@Test
	void getStudent_failure() {
		Student c = null;
		assertThrows(NoSuchElementException.class, () -> {
			studentService.getStudent(-1);	
		});
	}
	
	@Test
	void saveStudent_success() {
		assertDoesNotThrow(() -> {
			Student c =  new Student(700, "1234569", "123", "phone", "fullName");
			studentService.saveStudent(c);
		});
		
		assertDoesNotThrow(() -> {
			Student c = studentService.getStudent(700);
			assertNotNull(c);
		});
		
		//housecleaning
		assertDoesNotThrow(() -> {
			studentService.deleteStudent(700);
		});
		
		//test deletion success
		assertThrows(NoSuchElementException.class, () -> {
			studentService.getStudent(700);	
		});
	}
}
