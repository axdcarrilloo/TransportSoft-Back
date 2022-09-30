package transportSoft.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteModificarDto {
	
	private Long id;
	
	private String tipoDocumento;
	
	private String documento;
	
	private String nombres;
	
	private String apellidos;
	
	private String direccion;
	
	private String ciudad;
	
	private String correo;
	
	private String telefono;

}
