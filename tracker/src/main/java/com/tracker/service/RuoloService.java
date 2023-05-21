package com.tracker.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.dto.RuoloDTO;
import com.tracker.entity.RuoloEntity;
import com.tracker.mapper.RuoloMapper;
import com.tracker.repository.RuoloRepository;

import exception.BadRequestException;
import lombok.AllArgsConstructor;

/**
 * Service class for managing Ruolo (Role) entities.
 */
@Service
@AllArgsConstructor
public class RuoloService {

	@Autowired
	private RuoloRepository ruoloRepository;

	/**
	 * Retrieves a list of all RuoloDTO (Role Data Transfer Objects).
	 *
	 * @return A list of RuoloDTO objects representing all roles.
	 */
	public List<RuoloDTO> getAllRuoli() {

		List<RuoloEntity> listEntity = ruoloRepository.findAll();

		List<RuoloDTO> listDTO = listEntity.stream().map(entity -> RuoloMapper.mapEntityToDTO(entity))
				.collect(Collectors.toList());

		return listDTO;
	}

	/**
	 * Retrieves a RuoloEntity (Role Entity) by its ID.
	 *
	 * @param ruoloId The ID of the role to retrieve.
	 * @return The RuoloEntity object representing the role.
	 * @throws BadRequestException if the role with the specified ID does not exist.
	 */
	public RuoloEntity getRuoloById(int ruoloId) {
		if (!ruoloRepository.existsById(ruoloId)) {
			throw new BadRequestException("Ruolo with ID " + ruoloId + " does not exists");
		}
		return ruoloRepository.findById(ruoloId).get();
	}

	/**
	 * Adds a new Ruolo (Role) based on the provided RuoloDTO (Role Data Transfer
	 * Object).
	 *
	 * @param ruoloDTO The RuoloDTO object representing the role to add.
	 */
	public void addRuolo(RuoloDTO ruoloDTO) {

		ruoloRepository.save(RuoloMapper.mapDTOToEntity(ruoloDTO));
	}

	/**
	 * Deletes a Ruolo (Role) with the specified ID.
	 *
	 * @param ruoloId The ID of the role to delete.
	 * @throws BadRequestException if the role with the specified ID does not exist.
	 */
	public void deleteRuolo(int ruoloId) {
		if (!ruoloRepository.existsById(ruoloId)) {
			throw new BadRequestException("Ruolo with Id " + ruoloId + " does not exist.");
		}

		RuoloEntity ruolo = this.getRuoloById(ruoloId);

		ruolo.getUtenti().stream().forEach(utente -> utente.setRuolo(null));

		ruoloRepository.deleteById(ruoloId);

	}

	/**
	 * Saves an updated Ruolo (Role) based on the provided RuoloDTO (Role Data
	 * Transfer Object).
	 *
	 * @param ruoloDTO The RuoloDTO object representing the role to update.
	 */
	public void saveRuolo(RuoloDTO ruoloDTO) {
		RuoloEntity ruolo = this.getRuoloById(ruoloDTO.getId());
		ruolo.setNome(ruoloDTO.getNome());
		ruoloRepository.save(ruolo);

	}

}
