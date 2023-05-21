package com.tracker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A class representing a Ruolo DTO (Data Transfer Object) with rol
 * information.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RuoloDTO {

	private int id;
	private String nome;

}
