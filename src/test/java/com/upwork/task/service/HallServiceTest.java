package com.upwork.task.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.upwork.task.TaskApplication;
import com.upwork.task.model.Hall;

@SpringBootTest(classes = TaskApplication.class)
class HallServiceTest {
	@Autowired
	private HallService hallService;
		
	@Test
	void listAllHall_success() {
		assertDoesNotThrow(() -> {
			List<Hall> hallsList = hallService.listAllHall();
			assertNotNull(hallsList);
		});
	}
	
	@Test
	void getHall_success() {
		assertDoesNotThrow(() -> {
			Hall c = hallService.getHall(1);
			assertNotNull(c);
		});
	}

	@Test
	void getHall_failure() {
		Hall c = null;
		assertThrows(NoSuchElementException.class, () -> {
			hallService.getHall(-1);	
		});
	}
	
	@Test
	void saveHall_success() {
		assertDoesNotThrow(() -> {
			Hall c =  new Hall(700, "idHall", "name");
			hallService.saveHall(c);
		});
		
		assertDoesNotThrow(() -> {
			Hall c = hallService.getHall(700);
			assertNotNull(c);
		});
		
		//housecleaning
		assertDoesNotThrow(() -> {
			hallService.deleteHall(700);
		});
		
		//test deletion success
		assertThrows(NoSuchElementException.class, () -> {
			hallService.getHall(700);	
		});
	}
}
