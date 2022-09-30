package transportSoft.mappers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import transportSoft.domain.dtos.PuertoRegistrarDto;
import transportSoft.domain.entities.PuertoEntity;
import transportSoft.services.ClienteService;

public class PuertoMapper {
	
	private static Logger log = LoggerFactory.getLogger(ClienteService.class);
	
	public static PuertoEntity convertirDtoToEntity(PuertoRegistrarDto puerto) {
		log.info("PuertoMapper.class : convertirDtoToEntity() -> Convirtiendo de PuertoRegistrarDto a PuertoEntity...!");
		return new PuertoEntity(0L, puerto.getNombre(), puerto.getDireccion(), puerto.getCiudad());
	}

}
