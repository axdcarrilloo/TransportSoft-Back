package transportSoft.mappers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import transportSoft.domain.dtos.EntregaMaritimaRegistrarDto;
import transportSoft.domain.entities.EntregaMaritimaEntity;

public class EntregaMaritimaMapper {
	
private static Logger log = LoggerFactory.getLogger(EntregaMaritimaMapper.class);
	
	public static EntregaMaritimaEntity convertirDtoToEntity(EntregaMaritimaRegistrarDto entrega) {
		log.info("EntregaMaritimaMapper.class : convertirDtoToEntity() -> Convirtiendo de EntregaMaritimaRegistrarDto a EntregaMaritimaEntity...!");
		return new EntregaMaritimaEntity(0L, entrega.getProducto(), entrega.getFlota(), entrega.getPuertoEntrega(),
				entrega.getCliente(), entrega.getPrefijo(), entrega.getNumeroGuia(), entrega.getPrecioEnvio(), entrega.getCantidad(), entrega.getDescuento(), 
				entrega.getTotal(), entrega.getFechaRegistro(), entrega.getFechaEntrega());
	}

}
