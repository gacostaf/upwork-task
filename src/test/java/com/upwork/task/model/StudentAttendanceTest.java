package com.upwork.task.model;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentAttendanceTest {
	@Test
	void createEmptyInstance_success() {
		StudentAttendance c = new StudentAttendance();
		assertNull(c.getFkIdStudent());
	}

	@Test
	void createInstance_success() {
		StudentAttendance c = getNewStudentAttendance();
		assertTrue(
				c.getPkStudentAttendance()==700 &&
				c.getFkIdStudent().equals("1234567") &&
				c.getFkIdLecture().equals("111-01")
				);
	}
	
	StudentAttendance getNewStudentAttendance() {
		return new StudentAttendance(700, "1234567", "111-01", new Date());
	}
}
