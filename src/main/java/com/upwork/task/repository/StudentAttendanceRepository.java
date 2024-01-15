package com.upwork.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upwork.task.model.StudentAttendance;

public interface StudentAttendanceRepository extends JpaRepository<StudentAttendance, Integer> {

}
