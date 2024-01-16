package com.upwork.task.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upwork.task.model.StudentSchedule;
import com.upwork.task.repository.StudentScheduleRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentScheduleService {
	@Autowired
	private StudentScheduleRepository studentScheduleRepository;
	
	public StudentScheduleService() {
		//Private empty constructor
	}

	public List<StudentSchedule> listAllStudentSchedule() {
		return studentScheduleRepository.findAll();
	}
	
	public StudentSchedule getStudentSchedule(Integer id) throws NoSuchElementException {
		Optional<StudentSchedule> optStudentSchedule = studentScheduleRepository.findById(id);
		if (optStudentSchedule.isEmpty()) {
			throw new NoSuchElementException();
		} else {
			return optStudentSchedule.get();
		}	
	}
	
	public void saveStudentSchedule(StudentSchedule studentSchedule) {
		studentScheduleRepository.save(studentSchedule);
	}
	
	public void deleteStudentSchedule(Integer id) {
		studentScheduleRepository.deleteById(id);
	}
	
	public StudentSchedule 
		findLectureByStudentCourseHall(String studentId, 
										String courseId, 
										String hallId,
										Date startDateTime,
										Date endDateTime) {
		return studentScheduleRepository.
				findLectureByStudentCourseHall(studentId, 
											   courseId, 
											   hallId,
											   startDateTime,
											   endDateTime);
		
	}
} 
