package transportSoft.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BodegasRegistrarDto {
	
	private String nombre;
	
	private String direccion;
	
	private String ciudad;

}
