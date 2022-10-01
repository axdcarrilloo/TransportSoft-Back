package transportSoft.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import transportSoft.domain.dtos.EntregaTerrestreRegistrarDto;
import transportSoft.domain.dtos.GuiaRegistrarDto;
import transportSoft.domain.entities.EntregaTerrestreEntity;
import transportSoft.domain.entities.GuiaEntity;
import transportSoft.mappers.EntregaTerrestreMapper;
import transportSoft.repositories.EntregaTerrestreRepository;
import transportSoft.utils.Constantes;

@Service
public class EntregaTerrestreService {
	
	private static Logger log = LoggerFactory.getLogger(EntregaTerrestreService.class);
	
	@Autowired
	private EntregaTerrestreRepository entregaTerrestreRepository;
	
	@Autowired
	private GuiaService guiaSvc;
	
	private Map<String, Object>  validarPrefijo(String prefijo) {
		Map<String, Object> map = new HashMap<>();
		Integer validar = 0;
		Integer prefijoLength = prefijo.length();
		if(prefijoLength != 3) {
			validar = 1;
			map.put("prefijoLength", Constantes.ERROR_CARACTERES_PREFIJO);
		}
		map.put("validacion", validar);
		return map;
	}
	
	private Map<String, Object> validarCamposVacios(EntregaTerrestreRegistrarDto entrega) {
		log.info("EntregaTerrestreService.class : validarCamposVacios() -> Validando campos de registro...!");
		Map<String, Object> map = new HashMap<>();
		Integer validar = 0;
		if(entrega.getProducto() == null) {
			validar = 1;
			map.put("producto", "Producto");
		} else if(entrega.getProducto().getId() == null) {
			validar = 1;
			map.put("producto", "Producto");
		}
		if(entrega.getCamion() == null) {
			validar = 1;
			map.put("camion", "Camion");
		} else if(entrega.getCamion().getId() == null) {
			validar = 1;
			map.put("camion", "Camion");
		}
		if(entrega.getBodegaEntrega() == null) {
			validar = 1;
			map.put("bodegaEntrega", "Bodega de Entrega");
		} else if(entrega.getBodegaEntrega().getId() == null) {
			validar = 1;
			map.put("bodegaEntrega", "Bodega de Entrega");
		}
		if(entrega.getCliente() == null) {
			validar = 1;
			map.put("cliente", "Cliente");
		} else if(entrega.getCliente().getId() == null) {
			validar = 1;
			map.put("cliente", "Cliente");
		}
		if(entrega.getPrefijo() == null) {
			validar = 1;
			map.put("prefijo", "Prefijo");
		} else if(entrega.getCliente().getId() == null) {
			validar = 1;
			map.put("prefijo", "Prefijo");
		}
		if(entrega.getNumeroGuia() == null) {
			map.put("numeroGuia", "Numero de Guia");
			validar = 1;
		}
		if(entrega.getPrecioEnvio() == null) {
			map.put("precioEnvio", "Precio de Envio");
			validar = 1;
		}
		if(entrega.getCantidad() == null) {
			map.put("cantidad", "Cantidad");
			validar = 1;
		}
		if(entrega.getFechaRegistro() == null) {
			map.put("fechaRegistro", "Fecha de Registro");
			validar = 1;
		}
		if(entrega.getFechaEntrega() == null) {
			map.put("fechaEntrega", "Fecha de Entrega");
			validar = 1;
		}
		map.put("validacion", validar);
		return map;
	}
	
	public Long eliminar(Long id) {
		log.info("EntregaTerrestreService.class : eliminar() -> Eliminando entrega...!");
		if(existenciaPorId(id)) {
			entregaTerrestreRepository.deleteById(id);
			return id;
		} else {
			return null;
		}	
	}
	
	public Boolean existenciaPorId(Long id) {
		log.info("EntregaTerrestreService.class : existenciaPorId() -> Validando existencia de entrega...!");
		if(consultarPorId(id) != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public EntregaTerrestreEntity consultarPorId(Long id) {
		log.info("EntregaTerrestreService.class : consultarPorId() -> Consultando entrega por Id...!");
		Optional<EntregaTerrestreEntity> optional = entregaTerrestreRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}
	
	public List<EntregaTerrestreEntity> consultarTodas(){
		log.info("EntregaTerrestreService.class : consultarTodas() -> Consultando todas los entregas...!");
		return entregaTerrestreRepository.findAll();
	}
	
	public Map<String, Object> registrar(EntregaTerrestreRegistrarDto entrega) {
		log.info("EntregaTerrestreService.class : registrar() -> Registrando entrega...!");
		Map<String, Object> map = validarCamposVacios(entrega);
		Map<String, Object> mapPrefijo = validarPrefijo(entrega.getPrefijo().toUpperCase());
		if((Integer)mapPrefijo.get("validacion") == 1 ) {
			map.put("prefijoLength", mapPrefijo.get("prefijoLength"));
			map.put("validacion", 1);
			return map;
		} else {
			GuiaEntity guia = guiaSvc.consultarPorPrefijo(entrega.getPrefijo().toUpperCase());
			if(guia == null) {
				guiaSvc.registrar(new GuiaRegistrarDto(entrega.getPrefijo().toUpperCase(), null, 
						Constantes.DESCRIPCION_ENTREGA_T));
			}
		}
		if((Integer)map.get("validacion") == 1) {
			return map;
		} else {
			map.clear();
			entrega.setNumeroGuia(guiaSvc.asignarGuia(entrega.getPrefijo().toUpperCase()));
			map.put("response", entregaTerrestreRepository.save(EntregaTerrestreMapper.convertirDtoToEntity(entrega)).getId());
			return map;
		}
	}

}
