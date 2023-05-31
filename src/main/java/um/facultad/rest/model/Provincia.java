/**
 * 
 */
package um.facultad.rest.model;

import java.io.Serializable;

import um.facultad.rest.model.pk.ProvinciaPk;
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
@Table
@IdClass(ProvinciaPk.class)
@NoArgsConstructor
@AllArgsConstructor
public class Provincia implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 6876985186039356090L;

	@Id
	@Column(name = "pro_fac_id")
	private Integer facultadId;

	@Id
	@Column(name = "idprovincia")
	private Integer provinciaId;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long unicoId;

	private String nombre = "";

}
