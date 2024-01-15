package com.upwork.task.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.NoSuchElementException;
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
	
	public Hall getHall(Integer id) throws NoSuchElementException {
		Optional<Hall> optHall = hallRepository.findById(id);
		if (optHall.isEmpty()) {
			throw new NoSuchElementException();
		} else {
			return optHall.get();
		}
	}
	
	public void saveHall(Hall hall) {
		hallRepository.save(hall);
	}
	
	public void deleteHall(Integer id) {
		hallRepository.deleteById(id);
	}
} 
