package com.tracker.mapper;

import com.tracker.dto.UtenteDTO;
import com.tracker.entity.RuoloEntity;
import com.tracker.entity.UtenteEntity;

/**
 * Utility class for mapping between `UtenteDTO` and `UtenteEntity`.
 */
public class UtenteMapper {

	/**
	 * Maps a `UtenteDTO` object to a `UtenteEntity` object.
	 *
	 * @param utenteDTO   The `UtenteDTO` object to map.
	 * @param ruoloEntity The `RuoloEntity` object to set in the `UtenteEntity`.
	 * @return The mapped `UtenteEntity` object.
	 */
	public static UtenteEntity mapDTOToEntity(UtenteDTO utenteDTO, RuoloEntity ruoloEntity) {

		UtenteEntity utenteEntity = new UtenteEntity();

		utenteEntity.setId(utenteDTO.getId());
		utenteEntity.setEmail(utenteDTO.getEmail());
		utenteEntity.setNome(utenteDTO.getNome());
		utenteEntity.setTelefono(utenteDTO.getTelefono());
		utenteEntity.setIndirizzo(utenteDTO.getIndirizzo());
		utenteEntity.setRuolo(ruoloEntity);

		return utenteEntity;
	}

	/**
	 * Maps a `UtenteEntity` object to a `UtenteDTO` object.
	 *
	 * @param utenteEntity The `UtenteEntity` object to map.
	 * @return The mapped `UtenteDTO` object.
	 */
	public static UtenteDTO mapEntityToDTO(UtenteEntity utenteEntity) {

		UtenteDTO utenteDTO = new UtenteDTO();

		utenteDTO.setId(utenteEntity.getId());
		utenteDTO.setEmail(utenteEntity.getEmail());
		utenteDTO.setNome(utenteEntity.getNome());
		utenteDTO.setTelefono(utenteEntity.getTelefono());
		utenteDTO.setIndirizzo(utenteEntity.getIndirizzo());
		utenteDTO.setRuoloId(utenteEntity.getRuolo().getId());
		utenteDTO.setRuolo(RuoloMapper.mapEntityToDTO(utenteEntity.getRuolo()));

		return utenteDTO;
	}
}
