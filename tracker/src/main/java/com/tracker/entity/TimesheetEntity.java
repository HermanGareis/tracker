package com.tracker.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents a Timesheet entity in the database. This entity is used to store and
 * retrieve timesheet data from the database.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "timesheet")
public class TimesheetEntity {

	@Id
	@SequenceGenerator(name = "timesheet_sequence", sequenceName = "timesheet_sequence", allocationSize = 1)
	@GeneratedValue(generator = "timesheet_sequence", strategy = GenerationType.SEQUENCE)
	@Column(name = "timesheet_id")
	private int id;
	private LocalDate data;
	private int ore;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "commessa_id", referencedColumnName = "commessa_id")
	private CommessaEntity commessa;
}
