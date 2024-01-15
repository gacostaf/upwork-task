package com.upwork.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upwork.task.model.Hall;

public interface HallRepository extends JpaRepository<Hall, Integer> {

}
