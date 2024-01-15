package com.upwork.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upwork.task.model.StudentTransaction;

public interface StudentTransactionRepository extends JpaRepository<StudentTransaction, Integer> {

}
