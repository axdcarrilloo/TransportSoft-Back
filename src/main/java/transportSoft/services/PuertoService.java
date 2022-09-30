package transportSoft.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import transportSoft.domain.dtos.PuertoRegistrarDto;
import transportSoft.domain.entities.PuertoEntity;
import transportSoft.mappers.PuertoMapper;
import transportSoft.repositories.PuertoRepository;

@Service
public class PuertoService {
	
	private static Logger log = LoggerFactory.getLogger(PuertoService.class);
	
	@Autowired
	private PuertoRepository puertoRepository;
	
	private Map<String, Object> validarCamposVacios(PuertoRegistrarDto puerto) {
		log.info("PuertoService.class : validarCamposVacios() -> Validando campos de registro...!");
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
		log.info("UsuarioService.class : eliminar() -> Eliminando puerto...!");
		if(existenciaPorId(id)) {
			puertoRepository.deleteById(id);
			return id;
		} else {
			return null;
		}	
	}
	
	public Boolean existenciaPorId(Long id) {
		log.info("PuertoService.class : existenciaPorId() -> Validando existencia de puerto...!");
		if(consultarPorId(id) != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public PuertoEntity consultarPorId(Long id) {
		log.info("PuertoService.class : consultarPorId() -> Consultando puerto por Id...!");
		Optional<PuertoEntity> optional = puertoRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}
	
	public List<PuertoEntity> consultarTodos(){
		log.info("PuertoService.class : consultarTodos() -> Consultando todos los puertos...!");
		return puertoRepository.findAll();
	}
	
	public Map<String, Object> registrar(PuertoRegistrarDto puerto) {
		log.info("PuertoService.class : registrar() -> Registrando puerto...!");
		Map<String, Object> map = validarCamposVacios(puerto);
		if((Integer)map.get("validacion") == 1) {
			return map;
		} else {
			map.clear();
			map.put("response", puertoRepository.save(PuertoMapper.convertirDtoToEntity(puerto)).getId());
			return map;
		}
	}

}
