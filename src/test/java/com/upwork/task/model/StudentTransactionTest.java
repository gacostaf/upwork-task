package com.upwork.task.model;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentTransactionTest {
	@Test
	void createEmptyInstance_success() {
		StudentTransaction c = new StudentTransaction();
		assertNull(c.getIdTransaction());
	}

	@Test
	void createInstance_success() {
		StudentTransaction c = getNewStudentTransaction();
		assertTrue(
				c.getPkStudentTransaction()==700 &&
				c.getFkIdStudent().equals("1234567")
				);
	}
	
	StudentTransaction getNewStudentTransaction() {
		return new StudentTransaction(700, UUID.randomUUID().toString(), "1234567", new Date());
	}
}
