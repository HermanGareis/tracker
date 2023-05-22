package com.tracker.mapper;

import com.tracker.dto.ClienteDTO;
import com.tracker.entity.ClienteEntity;

/**
 * Utility class for mapping between `ClienteDTO` and `ClienteEntity`.
 */
public class ClienteMapper {

	/**
	 * Maps a `ClienteDTO` object to a `ClienteEntity` object.
	 *
	 * @param clienteDTO The `ClienteDTO` object to map.
	 * @return The mapped `ClienteEntity` object.
	 */
	public static ClienteEntity mapDTOToEntity(ClienteDTO clienteDTO) {

		ClienteEntity clienteEntity = new ClienteEntity();

		clienteEntity.setId(clienteDTO.getId());
		clienteEntity.setCodiceFiscale(clienteDTO.getCodiceFiscale());
		clienteEntity.setNome(clienteDTO.getNome());
		clienteEntity.setTelefono(clienteDTO.getTelefono());
		clienteEntity.setIndirizzo(clienteDTO.getIndirizzo());

		return clienteEntity;
	}

	/**
	 * Maps a `ClienteEntity` object to a `ClienteDTO` object.
	 *
	 * @param clienteEntity The `ClienteEntity` object to map.
	 * @return The mapped `ClienteDTO` object.
	 */
	public static ClienteDTO mapEntityToDTO(ClienteEntity clienteEntity) {

		ClienteDTO clienteDTO = new ClienteDTO();

		clienteDTO.setId(clienteEntity.getId());
		clienteDTO.setCodiceFiscale(clienteEntity.getCodiceFiscale());
		clienteDTO.setNome(clienteEntity.getNome());
		clienteDTO.setTelefono(clienteEntity.getTelefono());
		clienteDTO.setIndirizzo(clienteEntity.getIndirizzo());

		return clienteDTO;
	}

}
