package com.upwork.task.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

import com.upwork.task.model.Student;
import com.upwork.task.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentService {

	private StudentRepository studentRepository;
	
	private StudentService() {
		//Private empty constructor
	}

	@Autowired
	public StudentService(StudentRepository cr) {
		this.studentRepository = cr;
	}
	
	public List<Student> listAllStudent() {
		return studentRepository.findAll();
	}
	
	public Student getStudent(Integer id) throws NoSuchElementException {
		Optional<Student> optStudent = studentRepository.findById(id);
		if (optStudent.isEmpty()) {
			throw new NoSuchElementException();
		} else {
			return optStudent.get();
		}	
	}
	
	public void saveStudent(Student student) {
		studentRepository.save(student);
	}
	
	public void deleteStudent(Integer id) {
		studentRepository.deleteById(id);
	}
} 
