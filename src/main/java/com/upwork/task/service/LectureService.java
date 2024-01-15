package com.upwork.task.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

import com.upwork.task.model.Lecture;
import com.upwork.task.repository.LectureRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LectureService {

	private LectureRepository lectureRepository;
	
	private LectureService() {
		//Private empty constructor
	}

	@Autowired
	public LectureService(LectureRepository cr) {
		this.lectureRepository = cr;
	}
	
	public List<Lecture> listAllLecture() {
		return lectureRepository.findAll();
	}
	
	public Lecture getLecture(Integer id) throws NoSuchElementException {
		Optional<Lecture> optLecture = lectureRepository.findById(id);
		if (optLecture.isEmpty()) {
			throw new NoSuchElementException();
		} else {
			return optLecture.get();
		}

	}
	
	public void saveLecture(Lecture lecture) {
		lectureRepository.save(lecture);
	}
	
	public void deleteLecture(Integer id) {
		lectureRepository.deleteById(id);
	}
} 
