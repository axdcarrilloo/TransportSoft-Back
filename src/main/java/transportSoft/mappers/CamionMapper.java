package transportSoft.mappers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import transportSoft.domain.dtos.CamionRegistrarDto;
import transportSoft.domain.entities.CamionEntity;

public class CamionMapper {
	
private static Logger log = LoggerFactory.getLogger(CamionMapper.class);
	
	public static CamionEntity convertirDtoToEntity(CamionRegistrarDto camion) {
		log.info("CamionMapper.class : convertirDtoToEntity() -> Convirtiendo de CamionRegistrarDto a CamionEntity...!");
		return new CamionEntity(0L, camion.getPlaca(), camion.getDesripcion(), camion.getConductor());
	}

}
