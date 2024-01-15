package com.upwork.task.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.upwork.task.TaskApplication;
import com.upwork.task.model.Program;

@SpringBootTest(classes = TaskApplication.class)
class ProgramServiceTest {
	@Autowired
	private ProgramService programService;
		
	@Test
	void listAllProgram_success() {
		assertDoesNotThrow(() -> {
			List<Program> programsList = programService.listAllProgram();
			assertNotNull(programsList);
		});
	}
	
	@Test
	void getProgram_success() {
		assertDoesNotThrow(() -> {
			Program c = programService.getProgram(1);
			assertNotNull(c);
		});
	}

	@Test
	void getProgram_failure() {
		Program c = null;
		assertThrows(NoSuchElementException.class, () -> {
			programService.getProgram(-1);	
		});
	}
	
	@Test
	void saveProgram_success() {
		assertDoesNotThrow(() -> {
			Program c =  new Program(700, "idProgram", "name");
			programService.saveProgram(c);
		});
		
		assertDoesNotThrow(() -> {
			Program c = programService.getProgram(700);
			assertNotNull(c);
		});
		
		//housecleaning
		assertDoesNotThrow(() -> {
			programService.deleteProgram(700);
		});
		
		//test deletion success
		assertThrows(NoSuchElementException.class, () -> {
			programService.getProgram(700);	
		});
	}
}
