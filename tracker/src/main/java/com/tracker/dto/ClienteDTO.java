package com.tracker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A class representing a Cliente DTO (Data Transfer Object) with client
 * information.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

	private int id;
	private String codiceFiscale;
	private String nome;
	private String telefono;
	private String indirizzo;
}
