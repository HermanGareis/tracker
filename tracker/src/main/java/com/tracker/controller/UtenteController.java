package com.tracker.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.dto.ResponseBodyDTO;
import com.tracker.dto.UtenteDTO;
import com.tracker.response.ResponseGenerator;
import com.tracker.service.UtenteService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * This class is a controller for managing Utente (User) operations.
 */
@RestController
@RequestMapping(path = "api/utenti")
@AllArgsConstructor
@Slf4j
public class UtenteController {

	@Autowired
	private UtenteService utenteService;

	/**
	 * Retrieves all Utenti (Users).
	 *
	 * @return ResponseEntity with the response body containing the list of Utenti
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*", originPatterns = "*")
	@GetMapping
	public ResponseEntity<?> getAllUtenti() {

		@SuppressWarnings("rawtypes")
		ResponseBodyDTO body = null;

		Date startCallDate = new Date();
		log.info(String.format("getAllUtenti - startCallDate: %s", startCallDate));

		try {
			body = ResponseGenerator.generateResponse(utenteService.getAllUtenti(), HttpStatus.OK, startCallDate);
		} catch (Exception e) {
			log.error("Error occurred in getAllUtenti: " + e.getMessage());
			body = ResponseGenerator.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, startCallDate);
		}
		return ResponseEntity.ok(body);
	}

	/**
	 * Adds a new Utente (User).
	 *
	 * @param utenteDTO The UtenteDTO object representing the Utente to be added
	 * @return ResponseEntity with the response body indicating the result of the
	 *         operation
	 */
	@PostMapping
	public ResponseEntity<?> addUtente(@RequestBody UtenteDTO utenteDTO) {

		@SuppressWarnings("rawtypes")
		ResponseBodyDTO body = null;

		Date startCallDate = new Date();
		log.info(String.format("addUtente - startCallDate: %s", startCallDate));

		try {
			utenteService.addUtente(utenteDTO);
			body = ResponseGenerator.generateResponse("Correctly addUtente finished.", HttpStatus.OK, startCallDate);
		} catch (Exception e) {
			log.error("Error occurred in addUtente: " + e.getMessage());
			body = ResponseGenerator.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, startCallDate);
		}
		return ResponseEntity.ok(body);

	}

	/**
	 * Deletes a Utente (User) with the specified ID.
	 *
	 * @param utenteId The ID of the Utente to be deleted
	 * @return ResponseEntity with the response body indicating the result of the
	 *         operation
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*", originPatterns = "*")
	@DeleteMapping(path = "{utenteId}")
	public ResponseEntity<?> deleteUtente(@PathVariable("utenteId") int utenteId) {

		@SuppressWarnings("rawtypes")
		ResponseBodyDTO body = null;

		Date startCallDate = new Date();
		log.info(String.format("deleteUtente - startCallDate: %s", startCallDate));

		try {
			utenteService.deleteUtente(utenteId);
			body = ResponseGenerator.generateResponse("Correctly deleteUtente finished.", HttpStatus.OK, startCallDate);
		} catch (Exception e) {
			log.error("Error occurred in deleteUtente: " + e.getMessage());
			body = ResponseGenerator.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, startCallDate);
		}
		return ResponseEntity.ok(body);
	}

	/**
	 * Edits an existing Utente (User).
	 *
	 * @param utente The UtenteDTO object representing the updated Utente
	 * @return ResponseEntity with the response body indicating the result of the
	 *         operation
	 */
	@PutMapping
	public ResponseEntity<?> editUtente(@RequestBody UtenteDTO utenteDTO) {

		@SuppressWarnings("rawtypes")
		ResponseBodyDTO body = null;

		Date startCallDate = new Date();
		log.info(String.format("editUtente - startCallDate: %s", startCallDate));

		try {
			utenteService.saveUtente(utenteDTO);
			body = ResponseGenerator.generateResponse("Correctly editUtente finished.", HttpStatus.OK, startCallDate);
		} catch (Exception e) {
			log.error("Error occurred in editUtente: " + e.getMessage());
			body = ResponseGenerator.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, startCallDate);
		}
		return ResponseEntity.ok(body);
	}

	/**
	 * Assigns a Ruolo (Role) to a Utente (User).
	 *
	 * @param utenteId The ID of the Utente to which the Ruolo will be assigned
	 * @param ruoloId  The ID of the Ruolo to be assigned
	 * @return ResponseEntity with the response body indicating the result of the
	 *         operation
	 */
	@PutMapping("/{utenteId}/ruoli/{ruoloId}")
	public ResponseEntity<?> asignRuoloToUtente(@PathVariable int utenteId, @PathVariable int ruoloId) {

		@SuppressWarnings("rawtypes")
		ResponseBodyDTO body = null;

		Date startCallDate = new Date();
		log.info(String.format("editUtente - startCallDate: %s", startCallDate));

		try {
			utenteService.assignRuolo(utenteId, ruoloId);
			body = ResponseGenerator.generateResponse("Correctly editUtente finished.", HttpStatus.OK, startCallDate);
		} catch (Exception e) {
			log.error("Error occurred in editUtente: " + e.getMessage());
			body = ResponseGenerator.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, startCallDate);
		}
		return ResponseEntity.ok(body);

	}

}
