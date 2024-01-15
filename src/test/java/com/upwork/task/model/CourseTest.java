package com.upwork.task.model;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CourseTest {
	@Test
	void createEmptyInstance_success() {
		Course c = new Course();
		assertNull(c.getName());
	}

	@Test
	void createInstance_success() {
		Course c = getNewCourse();
		assertTrue(
				c.getPkCourse()==1 &&
				c.getFkIdProgram().equals("fkIdProgram") &&
				c.getIdCourse().equals("idCourse") &&
				c.getName().equals("name")
				);
	}
	
	Course getNewCourse() {
		return new Course(1, "fkIdProgram", "idCourse", "name");
	}
}
