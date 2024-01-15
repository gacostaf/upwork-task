package com.upwork.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upwork.task.model.StudentSchedule;

public interface StudentScheduleRepository extends JpaRepository<StudentSchedule, Integer> {

}
