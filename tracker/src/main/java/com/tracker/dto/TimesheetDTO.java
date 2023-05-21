package com.tracker.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A class representing a Timesheet DTO (Data Transfer Object) with timesheet information.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TimesheetDTO {
	
	private int id;
	private LocalDate data;
	private int ore;
	private int commessaId;
	@JsonIgnore
	private CommessaDTO commessaDTO;

}
