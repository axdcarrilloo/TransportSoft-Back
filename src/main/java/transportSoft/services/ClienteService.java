package transportSoft.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import transportSoft.domain.dtos.ClienteModificarDto;
import transportSoft.domain.dtos.ClienteRegistrarDto;
import transportSoft.domain.entities.ClienteEntity;
import transportSoft.mappers.ClienteMapper;
import transportSoft.repositories.ClienteRepository;
import transportSoft.utils.Constantes;

@Service
public class ClienteService {
	
	private static Logger log = LoggerFactory.getLogger(ClienteService.class);
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	private Map<String, Object> validarCamposVacios(ClienteRegistrarDto cliente) {
		log.info("ClienteService.class : validarCamposVacios() -> Validando campos de registro...!");
		Map<String, Object> map = new HashMap<>();
		Integer validar = 0;
		if(cliente.getTipoDocumento() == null) {
			map.put("tipoDocumento", "Tipo Documento");
			validar = 1;
		}
		if(cliente.getDocumento() == null) {
			map.put("documento", "Numero Documento");
			validar = 1;
		}
		if(cliente.getApellidos() == null) {
			map.put("apellidos", "Apellidos");
			validar = 1;
		}
		if(cliente.getDireccion() == null) {
			map.put("direccion", "Direccion");
			validar = 1;
		}
		if(cliente.getCiudad() == null) {
			map.put("ciudad", "Ciudad");
			validar = 1;
		}
		if(cliente.getCorreo() == null) {
			map.put("correo", "Correo");
			validar = 1;
		}
		if(cliente.getTelefono() == null) {
			map.put("telefono", "Telefono");
			validar = 1;
		}
		map.put("validacion", validar);
		return map;
	}
	
	public Long eliminar(Long id) {
		log.info("UsuarioService.class : eliminar() -> Eliminando usuario...!");
		if(existenciaPorId(id)) {
			clienteRepository.deleteById(id);
			return id;
		} else {
			return null;
		}	
	}
	
	public Boolean existenciaPorId(Long id) {
		log.info("ClienteService.class : existenciaPorId() -> Validando existencia de cliente...!");
		if(consultarPorId(id) != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean existenciaPorDocumento(String numeroDocumento) {
		log.info("ClienteService.class : existenciaPorDocumento() -> Validando existencia de cliente...!");
		if(consultarPorDocumento(numeroDocumento) != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public ClienteEntity consultarPorId(Long id) {
		log.info("ClienteService.class : consultarPorId() -> Consultando cliente por Id...!");
		Optional<ClienteEntity> optional = clienteRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}
	
	public ClienteEntity consultarPorDocumento(String documento) {
		log.info("ClienteService.class : consultarPorDocumento() -> Consultando cliente por numero de documento...!");
		Optional<ClienteEntity> optional = clienteRepository.findByDocumento(documento);
		if(optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}
	
	public List<ClienteEntity> consultarTodos(){
		log.info("ClienteService.class : consultarTodos() -> Consultando todos los clientes...!");
		return clienteRepository.findAll();
	}
	
	public Long modificarTodo(ClienteModificarDto cliente) {
		log.info("ClienteService.class : modificarTodo() -> Modificando cliente...!");
		ClienteEntity clienteMain = consultarPorId(cliente.getId());
		if(clienteMain != null) {
			clienteRepository.modificarTodo(cliente.getId(), cliente.getTipoDocumento(), cliente.getDocumento(), cliente.getNombres(), 
					cliente.getApellidos(), cliente.getDireccion(), cliente.getCiudad(), cliente.getCorreo(), cliente.getTelefono());
			return clienteMain.getId();
		} else {
			return null;
		}
	}
	
	public Map<String, Object> registrar(ClienteRegistrarDto cliente) {
		log.info("ClienteService.class : registrar() -> Registrando cliente...!");
		Map<String, Object> map = validarCamposVacios(cliente);
		if((Integer)map.get("validacion") == 1) {
			return map;
		}
		if(existenciaPorDocumento(cliente.getDocumento())) {
			map.put("existente", Constantes.SI_EXISTENCIA);
			return map;
		} else {
			map.clear();
			map.put("response", clienteRepository.save(ClienteMapper.convertirDtoToEntity(cliente)).getId());
			return map;
		}
	}

}
