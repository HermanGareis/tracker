package com.tracker.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.dto.CommessaDTO;
import com.tracker.entity.CommessaEntity;
import com.tracker.entity.OrdineClienteEntity;
import com.tracker.entity.UtenteEntity;
import com.tracker.mapper.CommessaMapper;
import com.tracker.repository.CommessaRepository;

import exception.BadRequestException;
import lombok.AllArgsConstructor;

/**
 * Service class for managing Commessa (Project) entities.
 */
@Service
@AllArgsConstructor
public class CommessaService {

	@Autowired
	private CommessaRepository commessaRepository;
	@Autowired
	private OrdineClienteService ordineClienteService;
	@Autowired
	private UtenteService utenteService;

	/**
	 * Retrieves a list of all CommessaDTO (Project Data Transfer Objects).
	 *
	 * @return A list of CommessaDTO objects representing all projects.
	 */
	public List<CommessaDTO> getAllCommesse() {

		List<CommessaEntity> listEntity = commessaRepository.findAll();

		List<CommessaDTO> listDTO = listEntity.stream().map(entity -> CommessaMapper.mapEntityToDTO(entity))
				.collect(Collectors.toList());

		return listDTO;
	}

	/**
	 * Retrieves a CommessaEntity (Project Entity) by its ID.
	 *
	 * @param commessaId The ID of the project to retrieve.
	 * @return The CommessaEntity object representing the project.
	 * @throws BadRequestException if the project with the specified ID does not
	 *                             exist.
	 */
	public CommessaEntity getCommessaById(int commessaId) {
		if (!commessaRepository.existsById(commessaId)) {
			throw new BadRequestException("Commessa with ID " + commessaId + " does not exists");
		}
		return commessaRepository.findById(commessaId).get();
	}

	/**
	 * Adds a new Commessa (Project) based on the provided CommessaDTO (Project Data
	 * Transfer Object).
	 *
	 * @param commessaDTO The CommessaDTO object representing the project to add.
	 */
	public void addCommessa(CommessaDTO commessaDTO) {

		OrdineClienteEntity ordine = ordineClienteService.getOrdineClienteById(commessaDTO.getOrdineId());
		UtenteEntity utente = utenteService.getUtenteById(commessaDTO.getUtenteId());

		CommessaEntity commessaEntity = CommessaMapper.mapDTOToEntity(commessaDTO, ordine, utente);

		commessaRepository.save(commessaEntity);
	}

	/**
	 * Deletes a Commessa (Project) with the specified ID.
	 *
	 * @param commessaId The ID of the project to delete.
	 * @throws BadRequestException if the project with the specified ID does not
	 *                             exist.
	 */
	public void deleteCommessa(int commessaId) {
		if (!commessaRepository.existsById(commessaId)) {
			throw new BadRequestException("Commessa with Id " + commessaId + " does not exist.");
		}

		commessaRepository.deleteById(commessaId);
	}

	/**
	 * Saves an updated Commessa (Project) based on the provided CommessaDTO
	 * (Project Data Transfer Object).
	 *
	 * @param commessaDTO The CommessaDTO object representing the project to update.
	 */
	public void saveCommessa(CommessaDTO commessaDTO) {
		OrdineClienteEntity ordine = ordineClienteService.getOrdineClienteById(commessaDTO.getOrdineId());
		UtenteEntity utente = utenteService.getUtenteById(commessaDTO.getUtenteId());

		CommessaEntity commessaEntity = CommessaMapper.mapDTOToEntity(commessaDTO, ordine, utente);

		commessaRepository.save(commessaEntity);
	}
}
