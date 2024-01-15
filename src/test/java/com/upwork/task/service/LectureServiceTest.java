package com.upwork.task.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.upwork.task.TaskApplication;
import com.upwork.task.model.Lecture;

@SpringBootTest(classes = TaskApplication.class)
class LectureServiceTest {
	@Autowired
	private LectureService lectureService;
		
	@Test
	void listAllLecture_success() {
		assertDoesNotThrow(() -> {
			List<Lecture> lecturesList = lectureService.listAllLecture();
			assertNotNull(lecturesList);
		});
	}
	
	@Test
	void getLecture_success() {
		assertDoesNotThrow(() -> {
			Lecture c = lectureService.getLecture(1);
			assertNotNull(c);
		});
	}

	@Test
	void getLecture_failure() {
		Lecture c = null;
		assertThrows(NoSuchElementException.class, () -> {
			lectureService.getLecture(-1);	
		});
	}
	
	@Test
	void saveLecture_success() {
		assertDoesNotThrow(() -> {
			Lecture c =  new Lecture(700, "idLecture", "111", "CBV-301", new Date(), new Date(), "instructor");
			lectureService.saveLecture(c);
		});
		
		assertDoesNotThrow(() -> {
			Lecture c = lectureService.getLecture(700);
			assertNotNull(c);
		});
		
		//housecleaning
		assertDoesNotThrow(() -> {
			lectureService.deleteLecture(700);
		});
		
		//test deletion success
		assertThrows(NoSuchElementException.class, () -> {
			lectureService.getLecture(700);	
		});
	}
}
