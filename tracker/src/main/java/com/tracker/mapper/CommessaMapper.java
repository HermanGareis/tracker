package com.tracker.mapper;

import com.tracker.dto.CommessaDTO;
import com.tracker.entity.CommessaEntity;
import com.tracker.entity.OrdineClienteEntity;
import com.tracker.entity.UtenteEntity;

/**
 * Utility class for mapping between `CommessaDTO` and `CommessaEntity`.
 */
public class CommessaMapper {

	/**
	 * Maps a `CommessaDTO` object to a `CommessaEntity` object.
	 *
	 * @param commessaDTO         The `CommessaDTO` object to map.
	 * @param ordineClienteEntity The associated `OrdineClienteEntity` object.
	 * @param utenteEntity        The associated `UtenteEntity` object.
	 * @return The mapped `CommessaEntity` object.
	 */
	public static CommessaEntity mapDTOToEntity(CommessaDTO commessaDTO, OrdineClienteEntity ordineClienteEntity,
			UtenteEntity utenteEntity) {

		CommessaEntity commessaEntity = new CommessaEntity();

		commessaEntity.setId(commessaDTO.getId());
		commessaEntity.setNome(commessaDTO.getNome());
		commessaEntity.setIsFatturato(commessaDTO.getIsFatturato());
		commessaEntity.setOrdineCliente(ordineClienteEntity);
		commessaEntity.setUtente(utenteEntity);

		return commessaEntity;
	}

	/**
	 * Maps a `CommessaEntity` object to a `CommessaDTO` object.
	 *
	 * @param commessaEntity The `CommessaEntity` object to map.
	 * @return The mapped `CommessaDTO` object.
	 */
	public static CommessaDTO mapEntityToDTO(CommessaEntity commessaEntity) {

		CommessaDTO commessaDTO = new CommessaDTO();

		commessaDTO.setId(commessaEntity.getId());
		commessaDTO.setNome(commessaEntity.getNome());
		commessaDTO.setIsFatturato(commessaEntity.getIsFatturato());
		commessaDTO.setOrdineId(commessaEntity.getOrdineCliente().getId());
		commessaDTO.setOrdineDTO(OrdineClienteMapper.mapEntityToDTO(commessaEntity.getOrdineCliente()));
		commessaDTO.setUtenteId(commessaEntity.getUtente().getId());
		commessaDTO.setUtenteDTO(UtenteMapper.mapEntityToDTO(commessaEntity.getUtente()));

		return commessaDTO;
	}

}
