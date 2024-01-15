package com.upwork.task.model;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProgramTest {
	@Test
	void createEmptyInstance_success() {
		Program c = new Program();
		assertNull(c.getName());
	}

	@Test
	void createInstance_success() {
		Program c = getNewProgram();
		assertTrue(
				c.getPkProgram()==700 &&
				c.getIdProgram().equals("idProgram") &&
				c.getName().equals("name")
				);
	}
	
	Program getNewProgram() {
		return new Program(700, "idProgram", "name");
	}
}
