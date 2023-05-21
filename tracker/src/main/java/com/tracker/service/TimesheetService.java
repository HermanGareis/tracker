package com.tracker.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.dto.TimesheetDTO;
import com.tracker.entity.CommessaEntity;
import com.tracker.entity.TimesheetEntity;
import com.tracker.mapper.TimesheetMapper;
import com.tracker.repository.TimesheetRepository;

import exception.BadRequestException;
import lombok.AllArgsConstructor;

/**
 * Service class for managing Timesheet entities.
 */
@Service
@AllArgsConstructor
public class TimesheetService {

	@Autowired
	private TimesheetRepository timesheetRepository;

	@Autowired
	private CommessaService commessaService;

	/**
	 * Retrieves a list of all TimesheetDTO objects.
	 *
	 * @return A list of TimesheetDTO objects representing all timesheets.
	 */
	public List<TimesheetDTO> getAllTimesheet() {

		List<TimesheetEntity> listEntity = timesheetRepository.findAll();

		List<TimesheetDTO> listDTO = listEntity.stream().map(entity -> TimesheetMapper.mapEntityToDTO(entity))
				.collect(Collectors.toList());

		return listDTO;
	}

	/**
	 * Retrieves a TimesheetEntity by its ID.
	 *
	 * @param timesheetId The ID of the timesheet to retrieve.
	 * @return The TimesheetEntity object representing the timesheet.
	 * @throws BadRequestException if the timesheet with the specified ID does not
	 *                             exist.
	 */
	public TimesheetEntity getTimesheetById(int timesheetId) {
		if (!timesheetRepository.existsById(timesheetId)) {
			throw new BadRequestException("Timesheet with ID " + timesheetId + " does not exists");
		}
		return timesheetRepository.findById(timesheetId).get();
	}

	/**
	 * Adds a new Timesheet based on the provided TimesheetDTO.
	 *
	 * @param timesheetDTO The TimesheetDTO object representing the timesheet to
	 *                     add.
	 */
	public void addTimesheet(TimesheetDTO timesheetDTO) {

		CommessaEntity commessa = commessaService.getCommessaById(timesheetDTO.getCommessaId());

		TimesheetEntity timesheetEntity = TimesheetMapper.mapDTOToEntity(timesheetDTO, commessa);

		timesheetRepository.save(timesheetEntity);
	}

	/**
	 * Deletes a Timesheet with the specified ID.
	 *
	 * @param timesheetId The ID of the timesheet to delete.
	 * @throws BadRequestException if the timesheet with the specified ID does not
	 *                             exist.
	 */
	public void deleteTimesheet(int timesheetId) {
		if (!timesheetRepository.existsById(timesheetId)) {
			throw new BadRequestException("Timesheet with Id " + timesheetId + " does not exist.");
		}

		timesheetRepository.deleteById(timesheetId);

	}

	/**
	 * Saves an updated Timesheet based on the provided TimesheetDTO.
	 *
	 * @param timesheetDTO The TimesheetDTO object representing the timesheet to
	 *                     update.
	 */
	public void saveTimesheet(TimesheetDTO timesheetDTO) {

		CommessaEntity commessa = commessaService.getCommessaById(timesheetDTO.getCommessaId());

		timesheetRepository.save(TimesheetMapper.mapDTOToEntity(timesheetDTO, commessa));
	}

}
