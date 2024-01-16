package com.upwork.task.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.upwork.task.model.StudentSchedule;
import com.upwork.task.model.StudentTransaction;

public interface StudentTransactionRepository extends JpaRepository<StudentTransaction, Integer> {
	@Query(value = "SELECT st FROM StudentTransaction st WHERE st.idTransaction = ?1", 
		   nativeQuery = false)
	StudentTransaction findStudentTransactionByUUID(String idTransaction);


}
