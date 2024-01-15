package com.upwork.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upwork.task.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
