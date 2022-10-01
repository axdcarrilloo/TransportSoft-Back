package transportSoft.mappers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import transportSoft.domain.dtos.FlotaRegistrarDto;
import transportSoft.domain.entities.FlotaEntity;

public class FlotaMapper {
	
	private static Logger log = LoggerFactory.getLogger(FlotaMapper.class);
	
	public static FlotaEntity convertirDtoToEntity(FlotaRegistrarDto flota) {
		log.info("FlotaMapper.class : convertirDtoToEntity() -> Convirtiendo de FlotaRegistrarDto a FlotaEntity...!");
		return new FlotaEntity(0L, flota.getNumero(), flota.getDesripcion(), flota.getCapitan());
	}

}
