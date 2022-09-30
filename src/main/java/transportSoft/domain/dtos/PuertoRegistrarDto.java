package transportSoft.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PuertoRegistrarDto {
	
	private Long id;
	
	private String nombre;
	
	private String direccion;
	
	private String ciudad;

}
