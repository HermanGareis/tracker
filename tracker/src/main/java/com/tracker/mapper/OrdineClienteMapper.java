package com.tracker.mapper;

import com.tracker.dto.OrdineClienteDTO;
import com.tracker.entity.ClienteEntity;
import com.tracker.entity.OrdineClienteEntity;

/**
 * Utility class for mapping between `OrdineClienteDTO` and
 * `OrdineClienteEntity`.
 */
public class OrdineClienteMapper {

	/**
	 * Maps an `OrdineClienteDTO` object to an `OrdineClienteEntity` object.
	 *
	 * @param ordineDTO The `OrdineClienteDTO` object to map.
	 * @param cliente   The associated `ClienteEntity` object.
	 * @return The mapped `OrdineClienteEntity` object.
	 */
	public static OrdineClienteEntity mapDTOToEntity(OrdineClienteDTO ordineDTO, ClienteEntity cliente) {

		OrdineClienteEntity ordineEntity = new OrdineClienteEntity();

		ordineEntity.setId(ordineDTO.getId());
		ordineEntity.setDettaglio(ordineDTO.getDettaglio());
		ordineEntity.setCliente(cliente);

		return ordineEntity;
	}

	/**
	 * Maps an `OrdineClienteEntity` object to an `OrdineClienteDTO` object.
	 *
	 * @param ordineEntity The `OrdineClienteEntity` object to map.
	 * @return The mapped `OrdineClienteDTO` object.
	 */
	public static OrdineClienteDTO mapEntityToDTO(OrdineClienteEntity ordineEntity) {

		OrdineClienteDTO ordineDTO = new OrdineClienteDTO();

		ordineDTO.setId(ordineEntity.getId());
		ordineDTO.setDettaglio(ordineEntity.getDettaglio());
		ordineDTO.setClienteId(ordineEntity.getCliente().getId());

		ordineDTO.setCliente(ClienteMapper.mapEntityToDTO(ordineEntity.getCliente()));

		return ordineDTO;
	}

}