package com.upwork.task.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="hall")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hall {
	@Id
	private int pkHall;
	private String idHall;
	private String name;

}
