package com.tracker.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A class representing a Commessa DTO (Data Transfer Object) with project
 * information.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommessaDTO {

	private int id;
	private String nome;
	private Boolean isFatturato;
	private int ordineId;
	private int utenteId;
	@JsonIgnore
	private OrdineClienteDTO ordineDTO;
	@JsonIgnore
	private UtenteDTO utenteDTO;

}
