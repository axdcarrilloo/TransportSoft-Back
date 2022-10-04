package transportSoft.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import transportSoft.domain.dtos.FlotaRegistrarDto;
import transportSoft.domain.entities.FlotaEntity;
import transportSoft.mappers.FlotaMapper;
import transportSoft.repositories.FlotaRepository;
import transportSoft.utils.Constantes;

@Service
public class FlotaService {
	
	private static Logger log = LoggerFactory.getLogger(FlotaService.class);
	
	@Autowired
	private FlotaRepository flotaRepository;
	
	private Map<String, Object>  validarNumeroFlota(String placa) {
		Map<String, Object> map = new HashMap<>();
		Integer validar = 0;
		Integer placaLength = placa.length();
		if(placaLength != 8) {
			map.put("numeroLength", Constantes.ERROR_CARACTERES_NUMERO);
			validar = 1;
			map.put("validacion", validar);
			return map;
		}
		String[] placaSplit = placa.split("-");
		String letras = placaSplit[0];
		String numeros = placa.substring(4, placa.length()-1);
		String ultimoCaracter = placa.substring(placa.length()-1);
		if(! Constantes.validarLetra(letras) ) {
			map.put("numeroLength", Constantes.ERROR_CARACTERES_NUMERO);
			validar = 1;
			map.put("validacion", validar);
			return map;
		}
		if(! Constantes.validarNumero(numeros) ) {
			map.put("numeroLength", Constantes.ERROR_CARACTERES_NUMERO);
			validar = 1;
			map.put("validacion", validar);
			return map;
		} 
		if(! Constantes.validarLetra(ultimoCaracter) ) {
			map.put("numeroLength", Constantes.ERROR_CARACTERES_NUMERO);
			validar = 1;
			map.put("validacion", validar);
			return map;
		} else {
			map.put("validacion", validar);
			return map;
		}
	}
	
	private Map<String, Object> validarCamposVacios(FlotaRegistrarDto flota) {
		log.info("FlotaService.class : validarCamposVacios() -> Validando campos de registro...!");
		Map<String, Object> map = new HashMap<>();
		Integer validar = 0;
		if(flota.getNumero() == null) {
			map.put("numero", "Numero");
			validar = 1;
		}
		if(flota.getCapitan() == null) {
			map.put("capitan", "Capitan");
			validar = 1;
		}
		map.put("validacion", validar);
		return map;
	}
	
	public Long eliminar(Long id) {
		log.info("FlotaService.class : eliminar() -> Eliminando flota...!");
		if(existenciaPorId(id)) {
			flotaRepository.deleteById(id);
			return id;
		} else {
			return null;
		}	
	}
	
	public Boolean existenciaPorId(Long id) {
		log.info("FlotaService.class : existenciaPorId() -> Validando existencia de flota...!");
		if(consultarPorId(id) != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public FlotaEntity consultarPorId(Long id) {
		log.info("FlotaService.class : consultarPorId() -> Consultando flota por Id...!");
		Optional<FlotaEntity> optional = flotaRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}
	
	public List<FlotaEntity> consultarTodas(){
		log.info("FlotaService.class : consultarTodas() -> Consultando todas las flotas...!");
		return flotaRepository.findAll();
	}
	
	public Map<String, Object> registrar(FlotaRegistrarDto flota) {
		log.info("FlotaService.class : registrar() -> Registrando flota...!");
		Map<String, Object> map = validarCamposVacios(flota);
		if((Integer)map.get("validacion") == 1) {
			return map;
		}
		Map<String, Object> mapNumeroFlota = validarNumeroFlota(flota.getNumero().toUpperCase());
		if((Integer)mapNumeroFlota.get("validacion") == 1) {
			map.put("numeroLength", mapNumeroFlota.get("numeroLength"));
			return map;
		} else {
			map.clear();
			flota.setNumero(flota.getNumero().toUpperCase());
			map.put("response", flotaRepository.save(FlotaMapper.convertirDtoToEntity(flota)).getId());
			return map;
		}
	}

}
