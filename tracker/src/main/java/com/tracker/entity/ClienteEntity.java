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
 * Represents a Cliente entity in the database. This entity is used to store and
 * retrieve cliente data from the database.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class ClienteEntity {

	@Id
	@SequenceGenerator(name = "cliente_sequence", sequenceName = "cliente_sequence", allocationSize = 1)
	@GeneratedValue(generator = "cliente_sequence", strategy = GenerationType.SEQUENCE)
	@Column(name = "cliente_id")
	private int id;

	@Column(nullable = false, unique = true)
	private String codiceFiscale;
	private String nome;
	private String telefono;
	private String indirizzo;

	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	private List<OrdineClienteEntity> ordine;
}