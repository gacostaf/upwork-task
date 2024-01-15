package com.upwork.task.model;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HallTest {
	@Test
	void createEmptyInstance_success() {
		Hall c = new Hall();
		assertNull(c.getName());
	}

	@Test
	void createInstance_success() {
		Hall c = getNewHall();
		assertTrue(
				c.getPkHall()==700 &&
				c.getIdHall().equals("idHall") &&
				c.getName().equals("name")
				);
	}
	
	Hall getNewHall() {
		return new Hall(700, "idHall", "name");
	}
}
