package com.upwork.task.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class CheckIn {
	private String studentId;
	private String courseId;
	private String hallId;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="America/Mexico_City")
	private Date checkInDate;

}
