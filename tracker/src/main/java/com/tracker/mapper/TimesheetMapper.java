package com.tracker.mapper;

import com.tracker.dto.TimesheetDTO;
import com.tracker.entity.CommessaEntity;
import com.tracker.entity.TimesheetEntity;

/**
 * Utility class for mapping between `TimesheetDTO` and `TimesheetEntity`.
 */
public class TimesheetMapper {

	/**
	 * Maps a `TimesheetDTO` object to a `TimesheetEntity` object.
	 *
	 * @param timesheetDTO   The `TimesheetDTO` object to map.
	 * @param commessaEntity The `CommessaEntity` object to set in the
	 *                       `TimesheetEntity`.
	 * @return The mapped `TimesheetEntity` object.
	 */
	public static TimesheetEntity mapDTOToEntity(TimesheetDTO timesheetDTO, CommessaEntity commessaEntity) {

		TimesheetEntity timesheetEntity = new TimesheetEntity();

		timesheetEntity.setId(timesheetDTO.getId());
		timesheetEntity.setData(timesheetDTO.getData());
		timesheetEntity.setOre(timesheetDTO.getOre());
		timesheetEntity.setCommessa(commessaEntity);

		return timesheetEntity;
	}

	/**
	 * Maps a `TimesheetEntity` object to a `TimesheetDTO` object.
	 *
	 * @param timesheetEntity The `TimesheetEntity` object to map.
	 * @return The mapped `TimesheetDTO` object.
	 */
	public static TimesheetDTO mapEntityToDTO(TimesheetEntity timesheetEntity) {

		TimesheetDTO timesheetDTO = new TimesheetDTO();

		timesheetDTO.setId(timesheetEntity.getId());
		timesheetDTO.setData(timesheetEntity.getData());
		timesheetDTO.setOre(timesheetEntity.getOre());
		timesheetDTO.setCommessaId(timesheetEntity.getCommessa().getId());
		timesheetDTO.setCommessaDTO(CommessaMapper.mapEntityToDTO(timesheetEntity.getCommessa()));

		return timesheetDTO;
	}

}
