package transportSoft.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import transportSoft.domain.dtos.GuiaModificarDto;
import transportSoft.domain.dtos.GuiaRegistrarDto;
import transportSoft.domain.entities.GuiaEntity;
import transportSoft.mappers.GuiaMapper;
import transportSoft.repositories.GuiaRepository;

@Service
public class GuiaService {
	
	private static Logger log = LoggerFactory.getLogger(GuiaService.class);
	
	@Autowired
	private GuiaRepository guiaRepository;
	
	private Map<String, Object> validarCamposVacios(GuiaRegistrarDto guia) {
		log.info("GuiaService.class : validarCamposVacios() -> Validando campos de registro...!");
		Map<String, Object> map = new HashMap<>();
		Integer validar = 0;
		if(guia.getPrefijo() == null) {
			map.put("prefijo", "Prefijo");
			validar = 1;
		}
		map.put("validacion", validar);
		return map;
	}
	
	public String asignarGuia(String prefijo) {
		log.info("GuiaService.class : asignarGuia() -> Asignando guia...!"
				+ prefijo +"...!");
		String guia = "";
		GuiaEntity guiaResponse = consultarPorPrefijo(prefijo);
		String consecutivoString = String.valueOf(guiaResponse.getConsecutivo());
		Integer consecutivoCaracteres = consecutivoString.length();
		switch (consecutivoCaracteres) {
			case 1:
				guia = guiaResponse.getPrefijo() + "000" + consecutivoString;
			break;
			case 2:
				guia = guiaResponse.getPrefijo() + "00" + consecutivoString;
			break;
			case 3:
				guia = guiaResponse.getPrefijo() + "0" + consecutivoString;
			break;
			case 4:
				guia = guiaResponse.getPrefijo() + consecutivoString;
			break;
			default:
			break;
		}
		modificarTodo(new GuiaModificarDto(guiaResponse.getId(), guiaResponse.getPrefijo(), (guiaResponse.getConsecutivo()+1), 
				guiaResponse.getDescripcion()));
		return guia;
	}
	
	public Boolean existenciaPorId(Long id) {
		log.info("GuiaService.class : existenciaPorId() -> Validando existencia de guia...!");
		if(consultarPorId(id) != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public GuiaEntity consultarPorPrefijo(String prefijo) {
		log.info("GuiaService.class : consultarPorPrefijo() -> Consultando guia por Prefijo...!");
		Optional<GuiaEntity> optional = guiaRepository.findByPrefijo(prefijo);
		if(optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}
	
	public GuiaEntity consultarPorId(Long id) {
		log.info("GuiaService.class : consultarPorId() -> Consultando guia por Id...!");
		Optional<GuiaEntity> optional = guiaRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}
	
	public Long modificarTodo(GuiaModificarDto guia) {
		log.info("GuiaService.class : modificarTodo() -> Modificando guia...!");
		GuiaEntity guiaMain = consultarPorId(guia.getId());
		if(guiaMain != null) {
			guiaRepository.modificarTodo(guiaMain.getId(), guia.getPrefijo(), guia.getConsecutivo(), guia.getDescripcion());
			return guia.getId();
		} else {
			return null;
		}
	}
	
	public Map<String, Object> registrar(GuiaRegistrarDto guia) {
		log.info("GuiaService.class : registrar() -> Registrando guia...!");
		Map<String, Object> map = validarCamposVacios(guia);
		if((Integer)map.get("validacion") == 1) {
			return map;
		} else {
			map.clear();
			guia.setConsecutivo(1);
			map.put("response", guiaRepository.save(GuiaMapper.convertirDtoToEntity(guia)).getId());
			return map;
		}
	}

}
