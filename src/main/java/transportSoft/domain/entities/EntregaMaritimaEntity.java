package transportSoft.domain.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "entregas_maritimas")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EntregaMaritimaEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 10)
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "id_producto", nullable = false, referencedColumnName = "id")
	private ProductoEntity producto;
	
	@ManyToOne
    @JoinColumn(name = "id_flota", nullable = false, referencedColumnName = "id")
	private FlotaEntity flota;
	
	@ManyToOne
    @JoinColumn(name = "id_bodega", nullable = false, referencedColumnName = "id")
	private PuertoEntity puertoEntrega;
	
	@ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false, referencedColumnName = "id")
	private ClienteEntity cliente;
	
	@Column(nullable = false, length = 4, unique = true)
	private String prefijo;
	
	@Column(nullable = false, length = 10)
	private String numeroGuia;
	
	@Column(nullable = false, length = 30)
	private Float precioEnvio;
	
	@Column(nullable = false, length = 30, unique = true)
	private Integer cantidad;
	
	@Column(nullable = false)
	private LocalDateTime fechaRegistro;
	
	@Column(nullable = false)
	private LocalDateTime fechaEntrega;

}
