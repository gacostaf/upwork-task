package com.upwork.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public Program getProgram(Integer id) {
		return programRepository.findById(id).get();
	}
	
	public void saveProgram(Program program) {
		programRepository.save(program);
	}
	
	public void deleteProgram(Integer id) {
		programRepository.deleteById(id);
	}
} 
