package transportSoft.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import transportSoft.domain.dtos.EntregaMaritimaRegistrarDto;
import transportSoft.domain.dtos.GuiaRegistrarDto;
import transportSoft.domain.entities.EntregaMaritimaEntity;
import transportSoft.domain.entities.GuiaEntity;
import transportSoft.mappers.EntregaMaritimaMapper;
import transportSoft.repositories.EntregaMaritimaRepository;
import transportSoft.utils.Constantes;

@Service
public class EntregaMaritimaService {
	
	private static Logger log = LoggerFactory.getLogger(EntregaMaritimaService.class);
	
	@Autowired
	private EntregaMaritimaRepository entregaMaritimaRepository;
	
	@Autowired
	private GuiaService guiaSvc;
	
	@Autowired
	private ProductoService productoSvc;
	
	@Autowired
	private CamionService camionSvc;
	
	@Autowired
	private BodegaService bodegaSvc;
	
	@Autowired
	private ClienteService clienteSvc;
	
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
	
	private Map<String, Object> validarCamposVacios(EntregaMaritimaRegistrarDto entrega) {
		log.info("EntregaMaritimaService.class : validarCamposVacios() -> Validando campos de registro...!");
		Map<String, Object> map = new HashMap<>();
		Integer validar = 0;
		if(entrega.getProducto() == null) {
			validar = 1;
			map.put("producto", "Producto");
		} else if(entrega.getProducto().getId() == null) {
			validar = 1;
			map.put("producto", "Producto");
		}
		if(entrega.getFlota() == null) {
			validar = 1;
			map.put("flota", "Flota");
		} else if(entrega.getFlota().getId() == null) {
			validar = 1;
			map.put("flota", "Flota");
		}
		if(entrega.getPuertoEntrega() == null) {
			validar = 1;
			map.put("puertoEntrega", "Puerto de Entrega");
		} else if(entrega.getPuertoEntrega().getId() == null) {
			validar = 1;
			map.put("puertoEntrega", "Puerto de Entrega");
		}
		if(entrega.getCliente() == null) {
			validar = 1;
			map.put("cliente", "Cliente");
		} else if(entrega.getCliente().getId() == null) {
			validar = 1;
			map.put("cliente", "Cliente");
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
		log.info("EntregaMaritimaService.class : eliminar() -> Eliminando entrega...!");
		if(existenciaPorId(id)) {
			entregaMaritimaRepository.deleteById(id);
			return id;
		} else {
			return null;
		}	
	}
	
	public Boolean existenciaPorId(Long id) {
		log.info("EntregaMaritimaService.class : existenciaPorId() -> Validando existencia de entrega...!");
		if(consultarPorId(id) != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public EntregaMaritimaEntity consultarPorId(Long id) {
		log.info("EntregaMaritimaService.class : consultarPorId() -> Consultando entrega por Id...!");
		Optional<EntregaMaritimaEntity> optional = entregaMaritimaRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}
	
	public List<EntregaMaritimaEntity> consultarTodas(){
		log.info("EntregaMaritimaService.class : consultarTodas() -> Consultando todas los entregas...!");
		return entregaMaritimaRepository.findAll();
	}
	
	public Map<String, Object> registrar(EntregaMaritimaRegistrarDto entrega) {
		log.info("EntregaMaritimaService.class : registrar() -> Registrando entrega...!");
		Map<String, Object> map = validarCamposVacios(entrega);
		Map<String, Object> mapPrefijo = validarPrefijo(entrega.getPrefijo().toUpperCase());
		if((Integer)mapPrefijo.get("validacion") == 1 ) {
			map.put("prefijoLength", mapPrefijo.get("prefijoLength"));
			map.put("validacion", 1);
			return map;
		} else {
			GuiaEntity guia = guiaSvc.consultarPorPrefijo(entrega.getPrefijo().toUpperCase());
			if(guia == null) {
				guiaSvc.registrar(new GuiaRegistrarDto(Constantes.PREFIJO_ENTREGA_M.toUpperCase(), null, 
						Constantes.DESCRIPCION_ENTREGA_T));
			}
		}
		if((Integer)map.get("validacion") == 1) {
			return map;
		}
		if(! productoSvc.existenciaPorId(entrega.getProducto().getId()) ) {
			map.put("inexistencia", Constantes.INEXISTENCIA_PRODUCTO);
			return map;
		}
		if(! camionSvc.existenciaPorId(entrega.getFlota().getId()) ) {
			map.put("inexistencia", Constantes.INEXISTENCIA_FLOTA);
			return map;
		} 
		if(! bodegaSvc.existenciaPorId(entrega.getPuertoEntrega().getId()) ) {
			map.put("inexistencia", Constantes.INEXISTENCIA_PUERTO);
			return map;
		}
		if(! clienteSvc.existenciaPorId(entrega.getCliente().getId()) ) {
			map.put("inexistencia", Constantes.INEXISTENCIA_CLIENTE);
			return map;
		} else {
			map.clear();
			entrega.setNumeroGuia(guiaSvc.asignarGuia(Constantes.PREFIJO_ENTREGA_M.toUpperCase()));
			map.put("response", entregaMaritimaRepository.save(EntregaMaritimaMapper.convertirDtoToEntity(entrega)).getId());
			return map;
		}
	}

}
