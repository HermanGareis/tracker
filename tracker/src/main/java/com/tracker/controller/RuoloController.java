package com.tracker.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.dto.ResponseBodyDTO;
import com.tracker.dto.RuoloDTO;
import com.tracker.response.ResponseGenerator;
import com.tracker.service.RuoloService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * This class is a controller for managing Ruolo (Role) operations.
 */
@RestController
@RequestMapping(path = "api/ruoli")
@AllArgsConstructor
@Slf4j
public class RuoloController {

	@Autowired
	private RuoloService ruoloService;

	/**
	 * Retrieves all Ruoli (Roles).
	 *
	 * @return ResponseEntity with the response body containing the list of Ruoli
	 */
	@GetMapping
	public ResponseEntity<?> getAllRuoli() {

		@SuppressWarnings("rawtypes")
		ResponseBodyDTO body = null;

		Date startCallDate = new Date();
		log.info(String.format("getAllRuoli - startCallDate: %s", startCallDate));

		try {
			body = ResponseGenerator.generateResponse(ruoloService.getAllRuoli(), HttpStatus.OK, startCallDate);
		} catch (Exception e) {
			log.error("Error occurred in getAllRuoli: " + e.getMessage());
			body = ResponseGenerator.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, startCallDate);
		}
		return ResponseEntity.ok(body);

	}

	/**
	 * Adds a new Ruolo (Role).
	 *
	 * @param ruoloDTO The RuoloDTO object representing the Ruolo to be added
	 * @return ResponseEntity with the response body indicating the result of the
	 *         operation
	 */
	@PostMapping
	public ResponseEntity<?> addRuolo(@RequestBody RuoloDTO ruoloDTO) {

		@SuppressWarnings("rawtypes")
		ResponseBodyDTO body = null;

		Date startCallDate = new Date();
		log.info(String.format("addRuolo - startCallDate: %s", startCallDate));

		try {
			ruoloService.addRuolo(ruoloDTO);
			body = ResponseGenerator.generateResponse("Correctly addRuolo finished.", HttpStatus.OK, startCallDate);
		} catch (Exception e) {
			log.error("Error occurred in addRuolo: " + e.getMessage());
			body = ResponseGenerator.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, startCallDate);
		}
		return ResponseEntity.ok(body);

	}

	/**
	 * Deletes a Ruolo (Role) with the specified ID.
	 *
	 * @param ruoloId The ID of the Ruolo to be deleted
	 * @return ResponseEntity with the response body indicating the result of the
	 *         operation
	 */
	@DeleteMapping(path = "{ruoloId}")
	public ResponseEntity<?> deleteRuolo(@PathVariable("ruoloId") int ruoloId) {
		@SuppressWarnings("rawtypes")
		ResponseBodyDTO body = null;

		Date startCallDate = new Date();
		log.info(String.format("deleteRuolo - startCallDate: %s", startCallDate));

		try {
			ruoloService.deleteRuolo(ruoloId);
			body = ResponseGenerator.generateResponse("Correctly deleteRuolo finished.", HttpStatus.OK, startCallDate);
		} catch (Exception e) {
			log.error("Error occurred in deleteRuolo: " + e.getMessage());
			body = ResponseGenerator.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, startCallDate);
		}
		return ResponseEntity.ok(body);

	}

	/**
	 * Edits an existing Ruolo (Role).
	 *
	 * @param ruoloDTO The RuoloDTO object representing the updated Ruolo
	 * @return ResponseEntity with the response body indicating the result of the
	 *         operation
	 */
	@PutMapping
	public ResponseEntity<?> editRuolo(@RequestBody RuoloDTO ruoloDTO) {
		@SuppressWarnings("rawtypes")
		ResponseBodyDTO body = null;

		Date startCallDate = new Date();
		log.info(String.format("editRuolo - startCallDate: %s", startCallDate));

		try {
			ruoloService.addRuolo(ruoloDTO);
			body = ResponseGenerator.generateResponse("Correctly editRuolo finished.", HttpStatus.OK, startCallDate);
		} catch (Exception e) {
			log.error("Error occurred in editRuolo: " + e.getMessage());
			body = ResponseGenerator.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, startCallDate);
		}
		return ResponseEntity.ok(body);

	}
}
