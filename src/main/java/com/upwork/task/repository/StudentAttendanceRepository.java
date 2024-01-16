package com.upwork.task.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.upwork.task.model.StudentAttendance;
import com.upwork.task.model.StudentCourse;

public interface StudentAttendanceRepository extends JpaRepository<StudentAttendance, Integer> {
	@Query(value = "SELECT sa FROM StudentAttendance sa WHERE sa.idTransaction = ?1", 
		   nativeQuery = false)
	StudentAttendance findAttendanceByIdTransaction(String idTransaction);

}
