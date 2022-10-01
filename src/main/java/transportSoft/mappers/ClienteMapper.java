package transportSoft.mappers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import transportSoft.domain.dtos.ClienteRegistrarDto;
import transportSoft.domain.entities.ClienteEntity;

public class ClienteMapper {
	
	private static Logger log = LoggerFactory.getLogger(ClienteMapper.class);
	
	public static ClienteEntity convertirDtoToEntity(ClienteRegistrarDto cliente) {
		log.info("ClienteMapper.class : convertirDtoToEntity() -> Convirtiendo de ClienteRegistrarDto a ClienteEntity...!");
		return new ClienteEntity(0L, cliente.getTipoDocumento(), cliente.getDocumento(), cliente.getNombres(),
				cliente.getApellidos(), cliente.getDireccion(), cliente.getCiudad(), cliente.getCorreo(),
				cliente.getTelefono());
	}

}
