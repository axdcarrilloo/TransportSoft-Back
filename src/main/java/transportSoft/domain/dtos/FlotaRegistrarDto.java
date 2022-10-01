package transportSoft.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FlotaRegistrarDto {
	
	private Long id;

	private String numero;
	
	private String desripcion;
	
	private String capitan;

}
