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

import com.tracker.dto.OrdineClienteDTO;
import com.tracker.dto.ResponseBodyDTO;
import com.tracker.response.ResponseGenerator;
import com.tracker.service.OrdineClienteService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * This class is a controller for managing OrdineCliente (Customer Order)
 * operations.
 */
@RestController
@RequestMapping(path = "api/ordini")
@AllArgsConstructor
@Slf4j
public class OrdineClienteController {

	@Autowired
	private OrdineClienteService ordineClienteService;

	/**
	 * Retrieves all OrdiniCliente (Customer Orders).
	 *
	 * @return ResponseEntity with the response body containing the list of
	 *         OrdiniCliente
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*", originPatterns = "*")
	@GetMapping
	public ResponseEntity<?> getAllOrdineCliente() {

		@SuppressWarnings("rawtypes")
		ResponseBodyDTO body = null;

		Date startCallDate = new Date();
		log.info(String.format("getAllOrdineCliente - startCallDate: %s", startCallDate));

		try {
			body = ResponseGenerator.generateResponse(ordineClienteService.getAllOrdini(), HttpStatus.OK,
					startCallDate);
		} catch (Exception e) {
			log.error("Error occurred in getAllOrdineCliente: " + e.getMessage());
			body = ResponseGenerator.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, startCallDate);
		}
		return ResponseEntity.ok(body);

	}

	/**
	 * Adds a new OrdineCliente (Customer Order).
	 *
	 * @param ordineClienteDTO The OrdineClienteDTO object representing the
	 *                         OrdineCliente to be added
	 * @return ResponseEntity with the response body indicating the result of the
	 *         operation
	 */
	@PostMapping
	public ResponseEntity<?> addOrdineCliente(@RequestBody OrdineClienteDTO ordineClienteDTO) {

		@SuppressWarnings("rawtypes")
		ResponseBodyDTO body = null;

		Date startCallDate = new Date();
		log.info(String.format("addOrdineCliente - startCallDate: %s", startCallDate));

		try {
			ordineClienteService.addOrdineCliente(ordineClienteDTO);
			body = ResponseGenerator.generateResponse("Correctly addOrdineCliente finished.", HttpStatus.OK,
					startCallDate);
		} catch (Exception e) {
			log.error("Error occurred in addOrdineCliente: " + e.getMessage());
			body = ResponseGenerator.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, startCallDate);
		}
		return ResponseEntity.ok(body);

	}

	/**
	 * Deletes an OrdineCliente (Customer Order) with the specified ID.
	 *
	 * @param ordineClienteId The ID of the OrdineCliente to be deleted
	 * @return ResponseEntity with the response body indicating the result of the
	 *         operation
	 */
	@DeleteMapping(path = "{ordineClienteId}")
	public ResponseEntity<?> deleteOrdineCliente(@PathVariable("ordineClienteId") int ordineClienteId) {
		@SuppressWarnings("rawtypes")
		ResponseBodyDTO body = null;

		Date startCallDate = new Date();
		log.info(String.format("deleteOrdineCliente - startCallDate: %s", startCallDate));

		try {
			ordineClienteService.deleteOrdineCliente(ordineClienteId);
			body = ResponseGenerator.generateResponse("Correctly deleteOrdineCliente finished.", HttpStatus.OK,
					startCallDate);
		} catch (Exception e) {
			log.error("Error occurred in deleteOrdineCliente: " + e.getMessage());
			body = ResponseGenerator.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, startCallDate);
		}
		return ResponseEntity.ok(body);

	}

	/**
	 * Edits an existing OrdineCliente (Customer Order).
	 *
	 * @param ordineClienteDTO The OrdineClienteDTO object representing the updated
	 *                         OrdineCliente
	 * @return ResponseEntity with the response body indicating the result of the
	 *         operation
	 */
	@PutMapping
	public ResponseEntity<?> editOrdineCliente(@RequestBody OrdineClienteDTO ordineClienteDTO) {

		@SuppressWarnings("rawtypes")
		ResponseBodyDTO body = null;

		Date startCallDate = new Date();
		log.info(String.format("editOrdineCliente - startCallDate: %s", startCallDate));

		try {
			ordineClienteService.saveOrdineCliente(ordineClienteDTO);
			body = ResponseGenerator.generateResponse("Correctly editOrdineCliente finished.", HttpStatus.OK,
					startCallDate);
		} catch (Exception e) {
			log.error("Error occurred in editOrdineCliente: " + e.getMessage());
			body = ResponseGenerator.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, startCallDate);
		}
		return ResponseEntity.ok(body);

	}
}
