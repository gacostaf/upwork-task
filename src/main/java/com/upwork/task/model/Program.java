package com.upwork.task.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="program")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Program {
	@Id
	private int pkProgram;
	private String idProgram;
	private String name;
}
