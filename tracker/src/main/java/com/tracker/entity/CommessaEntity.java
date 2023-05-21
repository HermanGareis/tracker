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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents a Commessa entity in the database. This entity is used to store and
 * retrieve commessa data from the database.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "commessa")
public class CommessaEntity {
	
	@Id
    @SequenceGenerator(
            name = "commessa_sequence",
            sequenceName = "commessa_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "commessa_sequence",
            strategy = GenerationType.SEQUENCE)
	@Column(name = "commessa_id")
	private int id;

	private String nome;
	
	private Boolean isFatturato;
	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ordine_id", referencedColumnName = "ordine_id")
	private OrdineClienteEntity ordineCliente;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "utente_id", referencedColumnName = "utente_id")
	private UtenteEntity utente;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "commessa")
	private List<TimesheetEntity> timesheet;
	
	
}
