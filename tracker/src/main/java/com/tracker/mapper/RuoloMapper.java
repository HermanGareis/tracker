package com.tracker.mapper;

import com.tracker.dto.RuoloDTO;
import com.tracker.entity.RuoloEntity;

/**
 * Utility class for mapping between `RuoloDTO` and `RuoloEntity`.
 */
public class RuoloMapper {

	/**
	 * Maps a `RuoloDTO` object to a `RuoloEntity` object.
	 *
	 * @param ruoloDTO The `RuoloDTO` object to map.
	 * @return The mapped `RuoloEntity` object.
	 */
	public static RuoloEntity mapDTOToEntity(RuoloDTO ruoloDTO) {

		RuoloEntity ruoloEntity = new RuoloEntity();

		ruoloEntity.setId(ruoloDTO.getId());
		ruoloEntity.setNome(ruoloDTO.getNome());

		return ruoloEntity;
	}

	/**
	 * Maps a `RuoloEntity` object to a `RuoloDTO` object.
	 *
	 * @param ruoloEntity The `RuoloEntity` object to map.
	 * @return The mapped `RuoloDTO` object.
	 */
	public static RuoloDTO mapEntityToDTO(RuoloEntity ruoloEntity) {

		RuoloDTO ruoloDTO = new RuoloDTO();

		ruoloDTO.setId(ruoloEntity.getId());
		ruoloDTO.setNome(ruoloEntity.getNome());

		return ruoloDTO;
	}

}
