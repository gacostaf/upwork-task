package com.upwork.task.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="student_course")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentCourse {
	@Id
	private int pkStudentCourse;
	private String fkIdStudent;
	private String fkIdCourse;
	private Date enrollmentDatetime;
	
}
