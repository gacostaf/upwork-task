package com.upwork.task.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="student_program")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentProgram {
	@Id
	private int pkStudentProgram;
	private String fkIdStudent;
	private String fkIdProgram;
	private Date enrollmentDatetime;
}
