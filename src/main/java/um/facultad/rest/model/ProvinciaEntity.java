/**
 * 
 */
package um.facultad.rest.model;

import java.io.Serial;
import java.io.Serializable;

import lombok.*;
import um.facultad.rest.model.pk.ProvinciaPk;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

/**
 * @author daniel
 *
 */
@Getter
@Setter
@Entity
@Table(name = "provincia")
@IdClass(ProvinciaPk.class)
@NoArgsConstructor
@AllArgsConstructor
public class ProvinciaEntity implements Serializable {
	/**
	* 
	*/
	@Serial
    private static final long serialVersionUID = 6876985186039356090L;

	@Id
	@Column(name = "pro_fac_id")
	private Integer facultadId;

	@Id
	@Column(name = "idprovincia")
	private Integer provinciaId;

	@Column(name = "id")
	private Long unicoId;

	private String nombre = "";

}
