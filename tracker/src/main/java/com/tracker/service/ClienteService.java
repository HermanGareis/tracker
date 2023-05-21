package com.tracker.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.dto.ClienteDTO;
import com.tracker.entity.ClienteEntity;
import com.tracker.mapper.ClienteMapper;
import com.tracker.repository.ClienteRepository;

import exception.BadRequestException;
import lombok.AllArgsConstructor;

/**
 * Service class for managing Cliente (Client) entities.
 */
@Service
@AllArgsConstructor
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	/**
	 * Retrieves a list of all ClienteDTO (Client Data Transfer Objects).
	 *
	 * @return A list of ClienteDTO objects representing all clients.
	 */
	public List<ClienteDTO> getAllClienti() {

		List<ClienteEntity> listEntity = clienteRepository.findAll();

		List<ClienteDTO> listDTO = listEntity.stream().map(entity -> ClienteMapper.mapEntityToDTO(entity))
				.collect(Collectors.toList());

		return listDTO;
	}

	/**
	 * Retrieves a ClienteEntity (Client Entity) by its ID.
	 *
	 * @param clienteId The ID of the client to retrieve.
	 * @return The ClienteEntity object representing the client.
	 * @throws BadRequestException if the client with the specified ID does not
	 *                             exist.
	 */
	public ClienteEntity getClienteById(int clienteId) {

		if (!clienteRepository.existsById(clienteId)) {
			throw new BadRequestException("Cliente with ID " + clienteId + " does not exists");
		}
		return clienteRepository.findById(clienteId).get();
	}

	/**
	 * Adds a new Cliente (Client) based on the provided ClienteDTO (Client Data
	 * Transfer Object).
	 *
	 * @param clienteDTO The ClienteDTO object representing the client to add.
	 */
	public void addCliente(ClienteDTO clienteDTO) {

		ClienteEntity clienteEntity = ClienteMapper.mapDTOToEntity(clienteDTO);

		Boolean existsCodiceFiscale = clienteRepository.selectExistsCodiceFiscale(clienteEntity.getCodiceFiscale());

		if (existsCodiceFiscale) {
			throw new BadRequestException("Codice fiscale " + clienteEntity.getCodiceFiscale() + " already used.");
		}

		clienteRepository.save(clienteEntity);
	}

	/**
	 * Deletes a Cliente (Client) with the specified ID.
	 *
	 * @param clienteId The ID of the client to delete.
	 * @throws BadRequestException if the client with the specified ID does not
	 *                             exist.
	 */
	public void deleteCliente(int clienteId) {
		if (!clienteRepository.existsById(clienteId)) {
			throw new BadRequestException("Cliente with Id " + clienteId + " does not exist.");
		}

		clienteRepository.deleteById(clienteId);
	}

	/**
	 * Saves an updated Cliente (Client) based on the provided ClienteDTO (Client
	 * Data Transfer Object).
	 *
	 * @param clienteDTO The ClienteDTO object representing the client to update.
	 */
	public void saveCliente(ClienteDTO clienteDTO) {
		clienteRepository.save(ClienteMapper.mapDTOToEntity(clienteDTO));

	}
}
