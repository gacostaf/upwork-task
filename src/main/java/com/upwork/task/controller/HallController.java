package com.upwork.task.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upwork.task.model.Hall;
import com.upwork.task.service.HallService;

@RestController
@RequestMapping("/hall")
public class HallController {
	@Autowired
	private HallService hallService;
	
	@GetMapping("")
	public List<Hall> getHalls() {
		return hallService.listAllHall();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Hall> getHall(@PathVariable Integer id) {
		try {
			Hall hall = hallService.getHall(id);
			return new ResponseEntity<Hall>(hall, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Hall>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/")
	public void saveHall(@RequestBody Hall hall) {
		hallService.saveHall(hall);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateHall(@PathVariable Integer id, 
										  @RequestBody Hall hall) {
		try {
			Hall originalUser = hallService.getHall(id);
			hall.setPkHall(id);
			hallService.saveHall(hall);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Hall>(HttpStatus.NOT_FOUND);			
		}
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteHall(@PathVariable Integer id) {
		hallService.deleteHall(id);
	}

}
