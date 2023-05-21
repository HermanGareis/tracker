package com.tracker.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents a OrdineCliente entity in the database. This entity is used to store and
 * retrieve ordineCliente data from the database.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ordine_cliente")
public class OrdineClienteEntity {

	@Id
	@SequenceGenerator(name = "ordine_sequence", sequenceName = "ordine_sequence", allocationSize = 1)
	@GeneratedValue(generator = "ordine_sequence", strategy = GenerationType.SEQUENCE)
	@Column(name = "ordine_id")
	private int id;
	private String dettaglio;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cliente_id", referencedColumnName = "cliente_id")
	private ClienteEntity cliente;

	@JsonIgnore
	@OneToOne(mappedBy = "ordineCliente")
	private CommessaEntity commessa;

}
