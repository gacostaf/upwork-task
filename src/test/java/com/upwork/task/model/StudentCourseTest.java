package com.upwork.task.model;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentCourseTest {
	@Test
	void createEmptyInstance_success() {
		StudentCourse c = new StudentCourse();
		assertNull(c.getFkIdCourse());
	}

	@Test
	void createInstance_success() {
		StudentCourse c = getNewStudentCourse();
		assertTrue(
				c.getPkStudentCourse()==700 &&
				c.getFkIdStudent().equals("1234567") &&
				c.getFkIdCourse().equals("111")
				);
	}
	
	StudentCourse getNewStudentCourse() {
		return new StudentCourse(700, "1234567", "111", new Date());
	}
}
