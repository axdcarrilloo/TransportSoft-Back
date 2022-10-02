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
@Table(name = "guias")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GuiaEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 10)
	private Long id;
	
	@Column(nullable = false, length = 4, unique = true)
	private String prefijo;
	
	@Column(nullable = false, length = 6)
	private Integer consecutivo;
	
	@Column(length = 100)
	private String descripcion;

}
