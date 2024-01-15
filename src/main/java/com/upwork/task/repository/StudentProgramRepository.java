package com.upwork.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upwork.task.model.StudentProgram;

public interface StudentProgramRepository extends JpaRepository<StudentProgram, Integer> {

}
