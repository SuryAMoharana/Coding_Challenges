package com.paypal.payloads;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sprints {
	private Integer id;
	private String name;
	private LocalDate start_date;
	private LocalDate end_date;
}
