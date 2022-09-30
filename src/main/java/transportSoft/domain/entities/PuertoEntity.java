package transportSoft.domain.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "puertos")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PuertoEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 10)
	private Long id;
	
	@Column(nullable = false, length = 30)
	private String nombre;
	
	@Column(nullable = false, length = 50)
	private String direccion;
	
	@Column(nullable = false, length = 10)
	private String ciudad;

}
