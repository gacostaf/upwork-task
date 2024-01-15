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
import com.upwork.task.model.Course;

@SpringBootTest(classes = TaskApplication.class)
class CourseServiceTest {
	@Autowired
	private CourseService courseService;
		
	@Test
	void listAllCourse_success() {
		assertDoesNotThrow(() -> {
			List<Course> coursesList = courseService.listAllCourse();
			assertNotNull(coursesList);
		});
	}
	
	@Test
	void getCourse_success() {
		assertDoesNotThrow(() -> {
			Course c = courseService.getCourse(1);
			assertNotNull(c);
		});
	}

	@Test
	void getCourse_failure() {
		Course c = null;
		assertThrows(NoSuchElementException.class, () -> {
			courseService.getCourse(-1);	
		});
	}
	
	@Test
	void saveCourse_success() {
		assertDoesNotThrow(() -> {
			Course c =  new Course(700, "CE-BS", "idCourse", "name");
			courseService.saveCourse(c);
		});
		
		assertDoesNotThrow(() -> {
			Course c = courseService.getCourse(700);
			assertNotNull(c);
		});
		
		//housecleaning
		assertDoesNotThrow(() -> {
			courseService.deleteCourse(700);
		});
		
		//test deletion success
		assertThrows(NoSuchElementException.class, () -> {
			courseService.getCourse(700);	
		});
	}
}
