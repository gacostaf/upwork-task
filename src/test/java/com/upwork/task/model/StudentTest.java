package com.upwork.task.model;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentTest {
	@Test
	void createEmptyInstance_success() {
		Student c = new Student();
		assertNull(c.getFullName());
	}

	@Test
	void createInstance_success() {
		Student c = getNewStudent();
		assertTrue(
				c.getPkStudent()==700 &&
				c.getIdStudent().equals("1234567") &&
				c.getCountry().equals("123") &&
				c.getPhone().equals("phone") &&
				c.getFullName().equals("fullName")
				);
	}
	
	Student getNewStudent() {
		return new Student(700, "1234567", "123", "phone", "fullName");
	}
}
