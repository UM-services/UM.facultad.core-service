/**
 * 
 */
package um.facultad.rest.model;

import java.io.Serializable;

import um.facultad.rest.model.pk.LocalidadPk;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author daniel
 *
 */
@Data
@Entity
@Table(name = "localidad")
@IdClass(LocalidadPk.class)
@NoArgsConstructor
@AllArgsConstructor
public class Localidad implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -202800533206288892L;

	@Id
	@Column(name = "loc_fac_id")
	private Integer facultadId;

	@Id
	@Column(name = "idprovincia")
	private Integer provinciaId;

	@Id
	@Column(name = "idlocalidad")
	private Integer localidadId;

	@Column(name = "id")
	private Long unicoId;

	private String nombre = "";

}
