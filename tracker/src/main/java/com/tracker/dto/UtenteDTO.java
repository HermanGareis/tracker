package com.tracker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A class representing a Utente DTO (Data Transfer Object) with user information.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UtenteDTO {

	private int id;
	private String email;
	private String nome;
	private String telefono;
	private String Indirizzo;
	private int ruoloId;
	private RuoloDTO ruolo;
}