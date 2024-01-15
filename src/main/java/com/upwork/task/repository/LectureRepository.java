package com.upwork.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upwork.task.model.Lecture;

public interface LectureRepository extends JpaRepository<Lecture, Integer> {

}
