package com.tracker.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents a Utente entity in the database. This entity is used to store and
 * retrieve utente data from the database.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "utente")
public class UtenteEntity {

	@Id
	@SequenceGenerator(name = "utente_sequence", sequenceName = "utente_sequence", allocationSize = 1)
	@GeneratedValue(generator = "utente_sequence", strategy = GenerationType.SEQUENCE)
	@Column(name = "utente_id")
	private int id;
	private String email;
	private String nome;
	private String telefono;
	private String Indirizzo;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ruolo_id", referencedColumnName = "ruolo_id", nullable = true)
	private RuoloEntity ruolo;

	@OneToMany(mappedBy = "utente")
	List<CommessaEntity> commessi;

	public void asignRuolo(RuoloEntity ruolo) {
		this.ruolo = ruolo;
	}

}
