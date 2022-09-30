package transportSoft.mappers;

import transportSoft.domain.dtos.ClienteRegistrarDto;
import transportSoft.domain.entities.ClienteEntity;

public class ClienteMapper {
	
	public static ClienteEntity convertirDtoToEntity(ClienteRegistrarDto cliente) {
		return new ClienteEntity(0L, cliente.getTipoDocumento(), cliente.getDocumento(), cliente.getNombres(),
				cliente.getApellidos(), cliente.getDireccion(), cliente.getCiudad(), cliente.getCorreo(),
				cliente.getTelefono());
	}

}
