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

import com.upwork.task.model.Lecture;
import com.upwork.task.service.LectureService;

@RestController
@RequestMapping("/lecture")
public class LectureController {
	@Autowired
	private LectureService lectureService;
	
	@GetMapping("")
	public List<Lecture> getLectures() {
		return lectureService.listAllLecture();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Lecture> getLecture(@PathVariable Integer id) {
		try {
			Lecture lecture = lectureService.getLecture(id);
			return new ResponseEntity<Lecture>(lecture, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Lecture>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/")
	public void saveLecture(@RequestBody Lecture lecture) {
		lectureService.saveLecture(lecture);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateLecture(@PathVariable Integer id, 
										  @RequestBody Lecture lecture) {
		try {
			Lecture originalUser = lectureService.getLecture(id);
			lecture.setPkLecture(id);
			lectureService.saveLecture(lecture);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Lecture>(HttpStatus.NOT_FOUND);			
		}
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteLecture(@PathVariable Integer id) {
		lectureService.deleteLecture(id);
	}

}
