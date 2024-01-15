package com.upwork.task.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

import com.upwork.task.model.Program;
import com.upwork.task.repository.ProgramRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProgramService {

	private ProgramRepository programRepository;
	
	private ProgramService() {
		//Private empty constructor
	}

	@Autowired
	public ProgramService(ProgramRepository cr) {
		this.programRepository = cr;
	}
	
	public List<Program> listAllProgram() {
		return programRepository.findAll();
	}
	
	public Program getProgram(Integer id) throws NoSuchElementException {
		Optional<Program> optProgram =  programRepository.findById(id);
		if (optProgram.isEmpty()) {
			throw new NoSuchElementException();
		} else {
			return optProgram.get();
		}	
	}
	
	public void saveProgram(Program program) {
		programRepository.save(program);
	}
	
	public void deleteProgram(Integer id) {
		programRepository.deleteById(id);
	}
} 
