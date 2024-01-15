package com.upwork.task.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="student_Transaction")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentTransaction {
	@Id
	private int pkStudentTransaction;
	private String idTransaction;
	private String fkIdStudent;
	private Date transactionDatetime;

}
