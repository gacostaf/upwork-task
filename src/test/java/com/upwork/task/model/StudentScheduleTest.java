package com.upwork.task.model;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentScheduleTest {
	@Test
	void createEmptyInstance_success() {
		StudentSchedule c = new StudentSchedule();
		assertNull(c.getFkIdLecture());
	}

	@Test
	void createInstance_success() {
		StudentSchedule c = getNewStudentSchedule();
		assertTrue(
				c.getPkStudentSchedule()==700 &&
				c.getFkIdStudent().equals("1234567") &&
				c.getFkIdLecture().equals("111-01")
				);
	}
	
	StudentSchedule getNewStudentSchedule() {
		return new StudentSchedule(700, "1234567", "111-01");
	}
}
