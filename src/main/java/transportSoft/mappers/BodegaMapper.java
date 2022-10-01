package transportSoft.mappers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import transportSoft.domain.dtos.BodegasRegistrarDto;
import transportSoft.domain.entities.BodegaEntity;

public class BodegaMapper {
	
	private static Logger log = LoggerFactory.getLogger(BodegaMapper.class);
	
	public static BodegaEntity convertirDtoToEntity(BodegasRegistrarDto bodega) {
		log.info("BodegaMapper.class : convertirDtoToEntity() -> Convirtiendo de BodegasRegistrarDto a BodegaEntity...!");
		return new BodegaEntity(0L, bodega.getNombre(), bodega.getDireccion(), bodega.getCiudad());
	}

}
