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

import com.tracker.dto.CommessaDTO;
import com.tracker.dto.ResponseBodyDTO;
import com.tracker.response.ResponseGenerator;
import com.tracker.service.CommessaService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * This class is a controller for managing Commessa (Job) operations.
 */
@RestController
@RequestMapping(path = "api/commessi")
@AllArgsConstructor
@Slf4j
public class CommessaController {

	@Autowired
	private CommessaService commessaService;

	/**
	 * Retrieves all Commesse (Jobs).
	 *
	 * @return ResponseEntity with the response body containing the list of Commesse
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*", originPatterns = "*")
	@GetMapping
	public ResponseEntity<?> getAllCommesse() {

		@SuppressWarnings("rawtypes")
		ResponseBodyDTO body = null;

		Date startCallDate = new Date();
		log.info(String.format("getAllCommesse - startCallDate: %s", startCallDate));

		try {
			body = ResponseGenerator.generateResponse(commessaService.getAllCommesse(), HttpStatus.OK, startCallDate);
		} catch (Exception e) {
			log.error("Error occurred in getAllCommesse: " + e.getMessage());
			body = ResponseGenerator.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, startCallDate);
		}
		return ResponseEntity.ok(body);
	}

	/**
	 * Adds a new Commessa (Job).
	 *
	 * @param commessaDTO The CommessaDTO object representing the Commessa to be
	 *                    added
	 * @return ResponseEntity with the response body indicating the result of the
	 *         operation
	 */
	@PostMapping
	public ResponseEntity<?> addCommessa(@RequestBody CommessaDTO commessaDTO) {

		@SuppressWarnings("rawtypes")
		ResponseBodyDTO body = null;

		Date startCallDate = new Date();
		log.info(String.format("addCommessa - startCallDate: %s", startCallDate));

		try {
			commessaService.addCommessa(commessaDTO);
			body = ResponseGenerator.generateResponse("Correctly addCommessa finished.", HttpStatus.OK, startCallDate);
		} catch (Exception e) {
			log.error("Error occurred in addCommessa: " + e.getMessage());
			body = ResponseGenerator.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, startCallDate);
		}
		return ResponseEntity.ok(body);

	}

	/**
	 * Deletes a Commessa (Job) with the specified ID.
	 *
	 * @param commessaId The ID of the Commessa to be deleted
	 * @return ResponseEntity with the response body indicating the result of the
	 *         operation
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*", originPatterns = "*")
	@DeleteMapping(path = "{commessaId}")
	public ResponseEntity<?> deleteCommessa(@PathVariable("commessaId") int commessaId) {

		@SuppressWarnings("rawtypes")
		ResponseBodyDTO body = null;

		Date startCallDate = new Date();
		log.info(String.format("deleteCommessa - startCallDate: %s", startCallDate));

		try {
			commessaService.deleteCommessa(commessaId);
			body = ResponseGenerator.generateResponse("Correctly deleteCommessa finished.", HttpStatus.OK,
					startCallDate);
		} catch (Exception e) {
			log.error("Error occurred in deleteCommessa: " + e.getMessage());
			body = ResponseGenerator.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, startCallDate);
		}
		return ResponseEntity.ok(body);
	}

	/**
	 * Edits an existing Commessa (Job).
	 *
	 * @param commessa The CommessaDTO object representing the updated Commessa
	 * @return ResponseEntity with the response body indicating the result of the
	 *         operation
	 */
	@PutMapping
	public ResponseEntity<?> editCommessa(@RequestBody CommessaDTO commessaDTO) {

		@SuppressWarnings("rawtypes")
		ResponseBodyDTO body = null;

		Date startCallDate = new Date();
		log.info(String.format("editCommessa - startCallDate: %s", startCallDate));

		try {
			commessaService.saveCommessa(commessaDTO);
			body = ResponseGenerator.generateResponse("Correctly editCommessa finished.", HttpStatus.OK, startCallDate);
		} catch (Exception e) {
			log.error("Error occurred in editCommessa: " + e.getMessage());
			body = ResponseGenerator.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, startCallDate);
		}
		return ResponseEntity.ok(body);
	}

}
