package com.upwork.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upwork.task.model.Hall;
import com.upwork.task.repository.HallRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class HallService {

	private HallRepository hallRepository;
	
	private HallService() {
		//Private empty constructor
	}

	@Autowired
	public HallService(HallRepository cr) {
		this.hallRepository = cr;
	}
	
	public List<Hall> listAllHall() {
		return hallRepository.findAll();
	}
	
	public Hall getHall(Integer id) {
		return hallRepository.findById(id).get();
	}
	
	public void saveHall(Hall Hall) {
		hallRepository.save(Hall);
	}
	
	public void deleteHall(Integer id) {
		hallRepository.deleteById(id);
	}
} 
