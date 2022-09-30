package transportSoft.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import transportSoft.domain.dtos.BodegasRegistrarDto;
import transportSoft.domain.entities.BodegaEntity;
import transportSoft.mappers.BodegaMapper;
import transportSoft.repositories.BodegaRepository;

@Service
public class BodegaService {
	
	private static Logger log = LoggerFactory.getLogger(BodegaService.class);
	
	@Autowired
	private BodegaRepository bodegaRepository;
	
	private Map<String, Object> validarCamposVacios(BodegasRegistrarDto puerto) {
		log.info("BodegaService.class : validarCamposVacios() -> Validando campos de registro...!");
		Map<String, Object> map = new HashMap<>();
		Integer validar = 0;
		if(puerto.getNombre() == null) {
			map.put("nombre", "Nombre");
			validar = 1;
		}
		if(puerto.getDireccion() == null) {
			map.put("direccion", "Direccion");
			validar = 1;
		}
		if(puerto.getCiudad() == null) {
			map.put("ciudad", "Ciudad");
			validar = 1;
		}
		map.put("validacion", validar);
		return map;
	}
	
	public Long eliminar(Long id) {
		log.info("BodegaService.class : eliminar() -> Eliminando bodega...!");
		if(existenciaPorId(id)) {
			bodegaRepository.deleteById(id);
			return id;
		} else {
			return null;
		}	
	}
	
	public Boolean existenciaPorId(Long id) {
		log.info("BodegaService.class : existenciaPorId() -> Validando existencia de bodega...!");
		if(consultarPorId(id) != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public BodegaEntity consultarPorId(Long id) {
		log.info("BodegaService.class : consultarPorId() -> Consultando bodega por Id...!");
		Optional<BodegaEntity> optional = bodegaRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}
	
	public List<BodegaEntity> consultarTodas(){
		log.info("BodegaService.class : consultarTodas() -> Consultando todas las bodegas...!");
		return bodegaRepository.findAll();
	}
	
	public Map<String, Object> registrar(BodegasRegistrarDto bodega) {
		log.info("BodegaService.class : registrar() -> Registrando bodega...!");
		Map<String, Object> map = validarCamposVacios(bodega);
		if((Integer)map.get("validacion") == 1) {
			return map;
		} else {
			map.clear();
			map.put("response", bodegaRepository.save(BodegaMapper.convertirDtoToEntity(bodega)).getId());
			return map;
		}
	}

}
