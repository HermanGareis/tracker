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

import com.tracker.dto.ClienteDTO;
import com.tracker.dto.ResponseBodyDTO;
import com.tracker.response.ResponseGenerator;
import com.tracker.service.ClienteService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * This class is a controller for managing clients.
 */
@RestController
@RequestMapping(path = "api/clienti")
@AllArgsConstructor
@Slf4j
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	/**
	 * Retrieves all clients.
	 *
	 * @return ResponseEntity containing the response body with all clients.
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*", originPatterns = "*")
	@GetMapping
	public ResponseEntity<?> getAllClienti() {

		@SuppressWarnings("rawtypes")
		ResponseBodyDTO body = null;

		Date startCallDate = new Date();
		log.info(String.format("getAllClienti - startCallDate: %s", startCallDate));

		try {
			body = ResponseGenerator.generateResponse(clienteService.getAllClienti(), HttpStatus.OK, startCallDate);
		} catch (Exception e) {
			log.error("Error occurred in getAllClienti: " + e.getMessage());
			body = ResponseGenerator.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, startCallDate);
		}
		return ResponseEntity.ok(body);
	}

	/**
	 * Adds a new client.
	 *
	 * @param clienteDTO The DTO object containing the client data to be added.
	 * @return ResponseEntity indicating the status of the operation.
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*", originPatterns = "*")
	@PostMapping
	public ResponseEntity<?> addCliente(@RequestBody ClienteDTO clienteDTO) {

		@SuppressWarnings("rawtypes")
		ResponseBodyDTO body = null;

		Date startCallDate = new Date();
		log.info(String.format("addCliente - startCallDate: %s", startCallDate));

		try {
			clienteService.addCliente(clienteDTO);
			body = ResponseGenerator.generateResponse("Correctly addCliente finished.", HttpStatus.OK, startCallDate);
		} catch (Exception e) {
			log.error("Error occurred in addCliente: " + e.getMessage());
			body = ResponseGenerator.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, startCallDate);
		}
		return ResponseEntity.ok(body);
	}

	/**
	 * Deletes a client with the specified ID.
	 *
	 * @param clienteId The ID of the client to be deleted.
	 * @return ResponseEntity indicating the status of the operation.
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*", originPatterns = "*")
	@DeleteMapping(path = "{clienteId}")
	public ResponseEntity<?> deleteCliente(@PathVariable("clienteId") int clienteId) {

		@SuppressWarnings("rawtypes")
		ResponseBodyDTO body = null;

		Date startCallDate = new Date();
		log.info(String.format("deleteCliente - startCallDate: %s", startCallDate));

		try {
			clienteService.deleteCliente(clienteId);
			body = ResponseGenerator.generateResponse("Correctly deleteCliente finished.", HttpStatus.OK,
					startCallDate);
		} catch (Exception e) {
			log.error("Error occurred in deleteCliente: " + e.getMessage());
			body = ResponseGenerator.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, startCallDate);
		}
		return ResponseEntity.ok(body);
	}

	/**
	 * Edits an existing client.
	 *
	 * @param clienteDTO The DTO object containing the updated client data.
	 * @return ResponseEntity indicating the status of the operation.
	 */
	@PutMapping
	public ResponseEntity<?> editCliente(@RequestBody ClienteDTO clienteDTO) {

		@SuppressWarnings("rawtypes")
		ResponseBodyDTO body = null;

		Date startCallDate = new Date();
		log.info(String.format("editCliente - startCallDate: %s", startCallDate));

		try {
			clienteService.saveCliente(clienteDTO);
			body = ResponseGenerator.generateResponse("Correctly editCliente finished.", HttpStatus.OK, startCallDate);
		} catch (Exception e) {
			log.error("Error occurred in editCliente: " + e.getMessage());
			body = ResponseGenerator.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, startCallDate);
		}
		return ResponseEntity.ok(body);

	}

}
