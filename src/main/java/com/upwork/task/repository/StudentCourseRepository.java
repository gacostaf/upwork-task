package com.upwork.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upwork.task.model.StudentCourse;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, Integer> {

}
