package transportSoft.domain.entities;

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
@Table(name = "flotas")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FlotaEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 10)
	private Long id;
	
	@Column(nullable = false, length = 30, unique = true)
	private String numero;
	
	@Column(length = 150)
	private String descripcion;
	
	@Column(nullable = false, length = 50)
	private String capitan;

}
