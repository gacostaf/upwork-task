package com.upwork.task.model;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LectureTest {
	@Test
	void createEmptyInstance_success() {
		Lecture c = new Lecture();
		assertNull(c.getInstructor());
	}

	@Test
	void createInstance_success() {
		Lecture c = getNewLecture();
		assertTrue(
				c.getPkLecture()==700 &&
				c.getIdLecture().equals("idLecture") &&
				c.getFkIdCourse().equals("111") &&
				c.getHall().equals("CBV-301") &&
 				c.getInstructor().equals("instructor")
				);
	}
	
	Lecture getNewLecture() {
		return new Lecture(700, "idLecture", "111", "CBV-301", new Date(), new Date(), "instructor");
	}
}
