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
@Table(name = "clientes")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteEntity implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 10)
	private Long id;
	
	@Column(name = "tipo_documento", nullable = false, length = 10)
	private String tipoDocumento;
	
	@Column(name = "documento", nullable = false, length = 100, unique = true)
	private String documento;
	
	@Column(length = 100)
	private String nombres;
	
	@Column(length = 100, nullable = false)
	private String apellidos;
	
	@Column(length = 100)
	private String direccion;
	
	@Column(nullable = false, length = 50)
	private String ciudad;
	
	@Column(nullable = false, length = 20)
	private String correo;
	
	@Column(nullable = false, length = 10)
	private String telefono;

}
