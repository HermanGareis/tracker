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
import com.tracker.dto.TimesheetDTO;
import com.tracker.response.ResponseGenerator;
import com.tracker.service.TimesheetService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * This class is a controller for managing Timesheet operations.
 */
@RestController
@RequestMapping(path = "api/timesheet")
@AllArgsConstructor
@Slf4j
public class TimesheetController {

	@Autowired
	private TimesheetService timesheetService;

	/**
	 * Retrieves all Timesheets.
	 *
	 * @return ResponseEntity with the response body containing the list of
	 *         Timesheets
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*", originPatterns = "*")
	@GetMapping
	public ResponseEntity<?> getAllTimesheet() {

		@SuppressWarnings("rawtypes")
		ResponseBodyDTO body = null;

		Date startCallDate = new Date();
		log.info(String.format("getAllTimesheet - startCallDate: %s", startCallDate));

		try {
			body = ResponseGenerator.generateResponse(timesheetService.getAllTimesheet(), HttpStatus.OK, startCallDate);
		} catch (Exception e) {
			log.error("Error occurred in getAllTimesheet: " + e.getMessage());
			body = ResponseGenerator.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, startCallDate);
		}
		return ResponseEntity.ok(body);
	}

	/**
	 * Adds a new Timesheet.
	 *
	 * @param timesheetDTO The TimesheetDTO object representing the Timesheet to be
	 *                     added
	 * @return ResponseEntity with the response body indicating the result of the
	 *         operation
	 */
	@PostMapping
	public ResponseEntity<?> addTimesheet(@RequestBody TimesheetDTO timesheetDTO) {

		@SuppressWarnings("rawtypes")
		ResponseBodyDTO body = null;

		Date startCallDate = new Date();
		log.info(String.format("addTimesheet - startCallDate: %s", startCallDate));

		try {
			timesheetService.addTimesheet(timesheetDTO);
			body = ResponseGenerator.generateResponse("Correctly addTimesheet finished.", HttpStatus.OK, startCallDate);
		} catch (Exception e) {
			log.error("Error occurred in addTimesheet: " + e.getMessage());
			body = ResponseGenerator.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, startCallDate);
		}
		return ResponseEntity.ok(body);

	}

	/**
	 * Deletes a Timesheet with the specified ID.
	 *
	 * @param timesheetId The ID of the Timesheet to be deleted
	 * @return ResponseEntity with the response body indicating the result of the
	 *         operation
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*", originPatterns = "*")
	@DeleteMapping(path = "{timesheetId}")
	public ResponseEntity<?> deleteTimesheet(@PathVariable("timesheetId") int timesheetId) {

		@SuppressWarnings("rawtypes")
		ResponseBodyDTO body = null;

		Date startCallDate = new Date();
		log.info(String.format("deleteTimesheet - startCallDate: %s", startCallDate));

		try {
			timesheetService.deleteTimesheet(timesheetId);
			body = ResponseGenerator.generateResponse("Correctly deleteTimesheet finished.", HttpStatus.OK,
					startCallDate);
		} catch (Exception e) {
			log.error("Error occurred in deleteTimesheet: " + e.getMessage());
			body = ResponseGenerator.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, startCallDate);
		}
		return ResponseEntity.ok(body);
	}

	/**
	 * Edits an existing Timesheet.
	 *
	 * @param timesheet The TimesheetDTO object representing the updated Timesheet
	 * @return ResponseEntity with the response body indicating the result of the
	 *         operation
	 */
	@PutMapping
	public ResponseEntity<?> editTimesheet(@RequestBody TimesheetDTO timesheetDTO) {

		@SuppressWarnings("rawtypes")
		ResponseBodyDTO body = null;

		Date startCallDate = new Date();
		log.info(String.format("editTimesheet - startCallDate: %s", startCallDate));

		try {
			timesheetService.saveTimesheet(timesheetDTO);
			body = ResponseGenerator.generateResponse("Correctly editTimesheet finished.", HttpStatus.OK,
					startCallDate);
		} catch (Exception e) {
			log.error("Error occurred in editTimesheet: " + e.getMessage());
			body = ResponseGenerator.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, startCallDate);
		}
		return ResponseEntity.ok(body);
	}

}
