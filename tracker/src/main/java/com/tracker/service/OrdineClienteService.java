package com.tracker.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.dto.OrdineClienteDTO;
import com.tracker.entity.ClienteEntity;
import com.tracker.entity.OrdineClienteEntity;
import com.tracker.mapper.OrdineClienteMapper;
import com.tracker.repository.OrdineClienteRepository;

import exception.BadRequestException;
import lombok.AllArgsConstructor;

/**
 * Service class for managing OrdineCliente (Customer Order) entities.
 */
@Service
@AllArgsConstructor
public class OrdineClienteService {

	@Autowired
	private OrdineClienteRepository ordineClienteRepository;

	@Autowired
	private ClienteService clienteService;

	/**
	 * Retrieves a list of all OrdineClienteDTO (Customer Order Data Transfer
	 * Objects).
	 *
	 * @return A list of OrdineClienteDTO objects representing all customer orders.
	 */
	public List<OrdineClienteDTO> getAllOrdini() {
		List<OrdineClienteEntity> listEntity = ordineClienteRepository.findAll();

		List<OrdineClienteDTO> listDTO = listEntity.stream().map(entity -> OrdineClienteMapper.mapEntityToDTO(entity))
				.collect(Collectors.toList());

		return listDTO;
	}

	/**
	 * Retrieves an OrdineClienteEntity (Customer Order Entity) by its ID.
	 *
	 * @param ordineClienteId The ID of the customer order to retrieve.
	 * @return The OrdineClienteEntity object representing the customer order.
	 * @throws BadRequestException if the customer order with the specified ID does
	 *                             not exist.
	 */
	public OrdineClienteEntity getOrdineClienteById(int ordineClienteId) {
		if (!ordineClienteRepository.existsById(ordineClienteId)) {
			throw new BadRequestException("OrdineCliente with ID " + ordineClienteId + " does not exists");
		}
		return ordineClienteRepository.findById(ordineClienteId).get();
	}

	/**
	 * Adds a new OrdineCliente (Customer Order) based on the provided
	 * OrdineClienteDTO (Customer Order Data Transfer Object).
	 *
	 * @param ordineClienteDTO The OrdineClienteDTO object representing the customer
	 *                         order to add.
	 */
	public void addOrdineCliente(OrdineClienteDTO ordineClienteDTO) {

		ClienteEntity cliente = clienteService.getClienteById(ordineClienteDTO.getClienteId());

		ordineClienteRepository.save(OrdineClienteMapper.mapDTOToEntity(ordineClienteDTO, cliente));
	}

	/**
	 * Deletes an OrdineCliente (Customer Order) with the specified ID.
	 *
	 * @param ordineClienteId The ID of the customer order to delete.
	 * @throws BadRequestException if the customer order with the specified ID does
	 *                             not exist.
	 */
	public void deleteOrdineCliente(int ordineClienteId) {
		if (!ordineClienteRepository.existsById(ordineClienteId)) {
			throw new BadRequestException("OrdineCliente with Id " + ordineClienteId + " does not exist.");
		}

		ordineClienteRepository.deleteById(ordineClienteId);
	}
	
	
	/**
	 * Saves an updated OrdineCliente based on the provided OrdineDTO (Ordine Data
	 * Transfer Object).
	 *
	 * @param ordineDTO The OrdineClienteDTO object representing the ordine to update.
	 */
	public void saveOrdineCliente(OrdineClienteDTO ordineDTO) {
		OrdineClienteEntity ordineEntity = this.getOrdineClienteById(ordineDTO.getId());
		
		ordineEntity.setDettaglio(ordineDTO.getDettaglio());
		ordineClienteRepository.save(ordineEntity);

	}
	
	
	
	
	
	
	
	
}
