package transportSoft.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import transportSoft.domain.dtos.ProductoRegistrarDto;
import transportSoft.domain.entities.ProductoEntity;
import transportSoft.mappers.ProductoMapper;
import transportSoft.repositories.ProductoRepository;

@Service
public class ProductoService {
	
	private static Logger log = LoggerFactory.getLogger(ProductoService.class);
	
	@Autowired
	private ProductoRepository productoRepository;
	
	private Map<String, Object> validarCamposVacios(ProductoRegistrarDto producto) {
		log.info("ProductoService.class : validarCamposVacios() -> Validando campos de registro...!");
		Map<String, Object> map = new HashMap<>();
		Integer validar = 0;
		if(producto.getTipoProducto() == null) {
			map.put("tipoProducto", "Tipo de Producto");
			validar = 1;
		}
		if(producto.getNombre() == null) {
			map.put("nombre", "Nombre");
			validar = 1;
		}
		if(producto.getTipoTransporte() == null) {
			map.put("tipoTransporte", "Tipo de Transporte");
			validar = 1;
		}
		map.put("validacion", validar);
		return map;
	}
	
	public Long eliminar(Long id) {
		log.info("ProductoService.class : eliminar() -> Eliminando producto...!");
		if(existenciaPorId(id)) {
			productoRepository.deleteById(id);
			return id;
		} else {
			return null;
		}	
	}
	
	public Boolean existenciaPorId(Long id) {
		log.info("ProductoService.class : existenciaPorId() -> Validando existencia de producto...!");
		if(consultarPorId(id) != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public ProductoEntity consultarPorId(Long id) {
		log.info("ProductoService.class : consultarPorId() -> Consultando producto por Id...!");
		Optional<ProductoEntity> optional = productoRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}
	
	public List<ProductoEntity> consultarTodos(){
		log.info("ProductoService.class : consultarTodos() -> Consultando todos los productos...!");
		return productoRepository.findAll();
	}
	
	public Map<String, Object> registrar(ProductoRegistrarDto producto) {
		log.info("ProductoService.class : registrar() -> Registrando producto...!");
		Map<String, Object> map = validarCamposVacios(producto);
		if((Integer)map.get("validacion") == 1) {
			return map;
		} else {
			map.clear();
			map.put("response", productoRepository.save(ProductoMapper.convertirDtoToEntity(producto)).getId());
			return map;
		}
	}

}
