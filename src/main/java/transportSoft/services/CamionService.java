package transportSoft.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import transportSoft.domain.dtos.CamionRegistrarDto;
import transportSoft.domain.entities.CamionEntity;
import transportSoft.mappers.CamionMapper;
import transportSoft.repositories.CamionRepository;
import transportSoft.utils.Constantes;

@Service
public class CamionService {
	
	private static Logger log = LoggerFactory.getLogger(CamionService.class);
	
	@Autowired
	private CamionRepository camionRepository;
	
	private Map<String, Object>  validarPlaca(String placa) {
		Map<String, Object> map = new HashMap<>();
		Integer validar = 0;
		Integer placaLength = placa.length();
		String[] placaSplit = placa.split("-");
		String letras = placaSplit[0];
		String numeros = placaSplit[1];
		if(placaLength != 7) {
			map.put("placaLength", Constantes.ERROR_CARACTERES_PLACA);
			validar = 1;
			map.put("validacion", validar);
			return map;
		}
		if(! Constantes.validarLetra(letras) ) {
			map.put("placaLength", Constantes.ERROR_CARACTERES_PLACA);
			validar = 1;
			map.put("validacion", validar);
			return map;
		}
		if(! Constantes.validarNumero(numeros) ) {
			map.put("placaLength", Constantes.ERROR_CARACTERES_PLACA);
			validar = 1;
			map.put("validacion", validar);
			return map;
		} else {
			map.put("validacion", validar);
			return map;
		}
	}
	
	private Map<String, Object> validarCamposVacios(CamionRegistrarDto camion) {
		log.info("CamionService.class : validarCamposVacios() -> Validando campos de registro...!");
		Map<String, Object> map = new HashMap<>();
		Integer validar = 0;
		if(camion.getPlaca() == null) {
			map.put("placa", "Placa");
			validar = 1;
		}
		if(camion.getConductor() == null) {
			map.put("conductor", "Conductor");
			validar = 1;
		}
		map.put("validacion", validar);
		return map;
	}
	
	public Long eliminar(Long id) {
		log.info("PuertoService.class : eliminar() -> Eliminando puerto...!");
		if(existenciaPorId(id)) {
			camionRepository.deleteById(id);
			return id;
		} else {
			return null;
		}	
	}
	
	public Boolean existenciaPorId(Long id) {
		log.info("CamionService.class : existenciaPorId() -> Validando existencia de camion...!");
		if(consultarPorId(id) != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public CamionEntity consultarPorId(Long id) {
		log.info("CamionService.class : consultarPorId() -> Consultando camion por Id...!");
		Optional<CamionEntity> optional = camionRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}
	
	public List<CamionEntity> consultarTodos(){
		log.info("CamionService.class : consultarTodos() -> Consultando todos los camiones...!");
		return camionRepository.findAll();
	}
	
	public Map<String, Object> registrar(CamionRegistrarDto camion) {
		log.info("CamionService.class : registrar() -> Registrando camion...!");
		Map<String, Object> map = validarCamposVacios(camion);
		Map<String, Object> mapPlaca = validarPlaca(camion.getPlaca().toUpperCase());
		if((Integer)map.get("validacion") == 1) {
			return map;
		} 
		if((Integer)mapPlaca.get("validacion") == 1) {
			map.put("placaLength", mapPlaca.get("placaLength"));
			return map;
		} else {
			map.clear();
			camion.setPlaca(camion.getPlaca().toUpperCase());
			map.put("response", camionRepository.save(CamionMapper.convertirDtoToEntity(camion)).getId());
			return map;
		}
	}

}
