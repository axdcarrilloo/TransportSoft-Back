package transportSoft.mappers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import transportSoft.domain.dtos.ProductoRegistrarDto;
import transportSoft.domain.entities.ProductoEntity;

public class ProductoMapper {
	
	private static Logger log = LoggerFactory.getLogger(ProductoMapper.class);
	
	public static ProductoEntity convertirDtoToEntity(ProductoRegistrarDto producto) {
		log.info("ProductoMapper.class : convertirDtoToEntity() -> Convirtiendo de ProductoRegistrarDto a ProductoEntity...!");
		return new ProductoEntity(0L, producto.getTipoProducto(), producto.getNombre(), producto.getTipoTransporte());
	}

}
