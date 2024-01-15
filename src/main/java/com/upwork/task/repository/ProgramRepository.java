package com.upwork.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upwork.task.model.Program;

public interface ProgramRepository extends JpaRepository<Program, Integer> {

}
