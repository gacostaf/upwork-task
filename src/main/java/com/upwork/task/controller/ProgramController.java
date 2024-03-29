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

import com.upwork.task.model.Program;
import com.upwork.task.service.ProgramService;

@RestController
@RequestMapping("/program")
public class ProgramController {
	@Autowired
	private ProgramService programService;
	
	@GetMapping("")
	public List<Program> getPrograms() {
		return programService.listAllProgram();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Program> getProgram(@PathVariable Integer id) {
		try {
			Program program = programService.getProgram(id);
			return new ResponseEntity<>(program, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/")
	public ResponseEntity<Program> saveProgram(@RequestBody Program program) {
		programService.saveProgram(program);
		return new ResponseEntity<>(program, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Program> updateProgram(@PathVariable Integer id, 
										  @RequestBody Program program) {
		try {
			program.setPkProgram(id);
			programService.saveProgram(program);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);			
		}
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteProgram(@PathVariable Integer id) {
		programService.deleteProgram(id);
	}

}
