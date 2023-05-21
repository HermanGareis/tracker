package com.tracker.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents a Ruolo entity in the database. This entity is used to store and
 * retrieve ruolo data from the database.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ruolo")
public class RuoloEntity {

	@Id
	@Column(name = "ruolo_id")
	@SequenceGenerator(name = "ruolo_sequence", sequenceName = "ruolo_sequence", allocationSize = 1)
	@GeneratedValue(generator = "ruolo_sequence", strategy = GenerationType.SEQUENCE)
	private int id;
	private String nome;

	@JsonIgnore
	@OneToMany(mappedBy = "ruolo")
	private List<UtenteEntity> utenti;
}
