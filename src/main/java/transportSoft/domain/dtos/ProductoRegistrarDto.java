package transportSoft.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductoRegistrarDto {
	
	private Long id;
	
	private String tipoProducto;
	
	private String nombre;
	
	private String tipoTransporte;

}
