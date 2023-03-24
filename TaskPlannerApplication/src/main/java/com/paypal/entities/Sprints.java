package com.paypal.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sprints {
	
	private Long id;
	private String name;
	private LocalDate start_date;
	private LocalDate end_date;

}
