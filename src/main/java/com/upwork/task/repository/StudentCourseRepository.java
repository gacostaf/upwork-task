package com.upwork.task.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.upwork.task.model.StudentCourse;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, Integer> {
	@Query(value = "SELECT sc FROM StudentCourse sc WHERE sc.fkIdStudent = ?1 and sc.fkIdCourse = ?2", 
		   nativeQuery = false)
    Collection<StudentCourse> findAllCoursesByStudent(String studentId, String courseId);

}
