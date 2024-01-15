package com.upwork.task.model;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentProgramTest {
	@Test
	void createEmptyInstance_success() {
		StudentProgram c = new StudentProgram();
		assertNull(c.getFkIdStudent());
	}

	@Test
	void createInstance_success() {
		StudentProgram c = getNewStudentProgram();
		assertTrue(
				c.getPkStudentProgram()==700 &&
				c.getFkIdStudent().equals("1234567") &&
				c.getFkIdProgram().equals("CE-BS")
				);
	}
	
	StudentProgram getNewStudentProgram() {
		return new StudentProgram(700, "1234567", "CE-BS", new Date());
	}
}
