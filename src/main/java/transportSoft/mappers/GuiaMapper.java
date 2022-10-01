package transportSoft.mappers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import transportSoft.domain.dtos.GuiaRegistrarDto;
import transportSoft.domain.entities.GuiaEntity;

public class GuiaMapper {
	
	private static Logger log = LoggerFactory.getLogger(GuiaMapper.class);
	
	public static GuiaEntity convertirDtoToEntity(GuiaRegistrarDto guia) {
		log.info("GuiaMapper.class : convertirDtoToEntity() -> Convirtiendo de GuiaRegistrarDto a GuiaEntity...!");
		return new GuiaEntity(0L, guia.getPrefijo(), guia.getConsecutivo(), guia.getDescripcion());
	}

}
