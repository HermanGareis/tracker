package com.tracker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A class representing a OrdineCliente DTO (Data Transfer Object) with client order information.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrdineClienteDTO {

	private int id;
	private String dettaglio;
	private int clienteId;
	private ClienteDTO cliente;
	
}
