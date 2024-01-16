package com.upwork.task.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="student_attendance")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentAttendance {
	@Id
	private int pkStudentAttendance;
	private String fkIdStudent;
	private String fkIdCourse;
	private String fkIdHall;
	private String fkIdLecture;
	private Date checkinDatetime;
	private String idTransaction;

}
