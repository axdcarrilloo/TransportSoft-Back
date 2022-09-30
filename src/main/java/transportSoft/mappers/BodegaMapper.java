package transportSoft.mappers;

import transportSoft.domain.dtos.BodegasRegistrarDto;
import transportSoft.domain.entities.BodegaEntity;

public class BodegaMapper {
	
	public static BodegaEntity convertirDtoToEntity(BodegasRegistrarDto bodega) {
		return new BodegaEntity(0L, bodega.getNombre(), bodega.getDireccion(), bodega.getCiudad());
	}

}
