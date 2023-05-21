package com.tracker.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.dto.UtenteDTO;
import com.tracker.entity.RuoloEntity;
import com.tracker.entity.UtenteEntity;
import com.tracker.mapper.UtenteMapper;
import com.tracker.repository.UtenteRepository;

import exception.BadRequestException;
import lombok.AllArgsConstructor;

/**
 * Service class for managing Utente (User) entities.
 */
@Service
@AllArgsConstructor
public class UtenteService {

	@Autowired
	private UtenteRepository utenteRepository;

	@Autowired
	private RuoloService ruoloService;

	/**
	 * Retrieves a list of all UtenteDTO (User Data Transfer Objects).
	 *
	 * @return A list of UtenteDTO objects representing all users.
	 */
	public List<UtenteDTO> getAllUtenti() {

		List<UtenteEntity> listEntity = utenteRepository.findAll();

		List<UtenteDTO> listDTO = listEntity.stream().map(entity -> UtenteMapper.mapEntityToDTO(entity))
				.collect(Collectors.toList());

		return listDTO;
	}

	/**
	 * Retrieves a UtenteEntity (User Entity) by its ID.
	 *
	 * @param utenteId The ID of the user to retrieve.
	 * @return The UtenteEntity object representing the user.
	 * @throws BadRequestException if the user with the specified ID does not exist.
	 */
	public UtenteEntity getUtenteById(int utenteId) {
		if (!utenteRepository.existsById(utenteId)) {
			throw new BadRequestException("Utente with ID " + utenteId + " does not exists");
		}
		return utenteRepository.findById(utenteId).get();
	}

	/**
	 * Adds a new Utente (User) based on the provided UtenteDTO (User Data Transfer
	 * Object).
	 *
	 * @param utenteDTO The UtenteDTO object representing the user to add.
	 * @throws BadRequestException if the email of the user already exists.
	 */
	public void addUtente(UtenteDTO utenteDTO) {

		RuoloEntity ruolo = ruoloService.getRuoloById(utenteDTO.getRuoloId());

		UtenteEntity utenteEntity = UtenteMapper.mapDTOToEntity(utenteDTO, ruolo);

		Boolean existsEmail = utenteRepository.selectExistsEmail(utenteEntity.getEmail());

		if (existsEmail) {
			throw new BadRequestException("Email " + utenteEntity.getEmail() + " already used.");
		}

		utenteRepository.save(utenteEntity);
	}

	/**
	 * Deletes a Utente (User) with the specified ID.
	 *
	 * @param utenteId The ID of the user to delete.
	 * @throws BadRequestException if the user with the specified ID does not exist.
	 */
	public void deleteUtente(int utenteId) {
		if (!utenteRepository.existsById(utenteId)) {
			throw new BadRequestException("Utente with Id " + utenteId + " does not exist.");
		}

		utenteRepository.deleteById(utenteId);

	}

	/**
	 * Saves an updated Utente (User) based on the provided UtenteDTO (User Data
	 * Transfer Object).
	 *
	 * @param utenteDTO The UtenteDTO object representing the user to update.
	 */
	public void saveUtente(UtenteDTO utenteDTO) {

		RuoloEntity ruolo = ruoloService.getRuoloById(utenteDTO.getRuoloId());

		utenteRepository.save(UtenteMapper.mapDTOToEntity(utenteDTO, ruolo));
	}

	/**
	 * Assigns a new Ruolo (Role) to a Utente (User) with the specified IDs.
	 *
	 * @param utenteId The ID of the user to assign the role to.
	 * @param ruoloId  The ID of the role to assign.
	 */
	public void assignRuolo(int utenteId, int ruoloId) {

		UtenteDTO utente = UtenteMapper.mapEntityToDTO(this.getUtenteById(utenteId));

		utente.setRuoloId(ruoloId);

		this.saveUtente(utente);

	}

}
