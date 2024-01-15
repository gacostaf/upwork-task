package com.upwork.task.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="lecture")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lecture {
	@Id
	private int pkLecture;
	private String idLecture;
	private String fkIdCourse;
	private String hall;
	private Date startDatetime;
	private Date endDatetime;
	private String instructor;

}
