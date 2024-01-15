package com.upwork.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upwork.task.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
