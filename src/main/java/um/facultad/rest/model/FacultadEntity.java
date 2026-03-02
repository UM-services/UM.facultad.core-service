/**
 * 
 */
package um.facultad.rest.model;

import java.io.Serial;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

/**
 * @author daniel
 *
 */
@Getter
@Setter
@Entity
@Table(name = "facultad")
@NoArgsConstructor
@AllArgsConstructor
public class FacultadEntity implements Serializable {
	/**
	 * 
	 */
	@Serial
    private static final long serialVersionUID = -2805822200533263537L;

	@Id
	@Column(name = "idfacultad")
	private Integer facultadId;

	private String nombre = "";

	@Column(name = "fac_acron")
	private String acronimo = "";
	
}
