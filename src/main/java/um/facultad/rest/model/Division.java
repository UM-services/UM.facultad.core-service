/**
 * 
 */
package um.facultad.rest.model;

import java.io.Serializable;

import um.facultad.rest.model.pk.DivisionPk;
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
@Table(name = "division")
@IdClass(DivisionPk.class)
@NoArgsConstructor
@AllArgsConstructor
public class Division implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -7834784673398234698L;

	@Id
	@Column(name = "idfacultad")
	private Integer facultadId;

	@Id
	@Column(name = "iddivision")
	private Integer divisionId;

	@Column(name = "clave")
	private Long uniqueId;

	private String nombre = "";

}
