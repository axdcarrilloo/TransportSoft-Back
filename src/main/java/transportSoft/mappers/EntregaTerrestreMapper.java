package transportSoft.mappers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import transportSoft.domain.dtos.EntregaTerrestreRegistrarDto;
import transportSoft.domain.entities.EntregaTerrestreEntity;

public class EntregaTerrestreMapper {
	
	private static Logger log = LoggerFactory.getLogger(EntregaTerrestreMapper.class);
	
	public static EntregaTerrestreEntity convertirDtoToEntity(EntregaTerrestreRegistrarDto entrega) {
		log.info("EntregaTerrestreMapper.class : convertirDtoToEntity() -> Convirtiendo de EntregaTerrestreRegistrarDto a EntregaTerrestreEntity...!");
		return new EntregaTerrestreEntity(0L, entrega.getProducto(), entrega.getCamion(), entrega.getBodegaEntrega(),
				entrega.getCliente(), entrega.getPrefijo(), entrega.getNumeroGuia(), entrega.getPrecioEnvio(), entrega.getCantidad(), entrega.getDescuento(), 
				entrega.getTotal(), entrega.getFechaRegistro(), entrega.getFechaEntrega());
	}

}
