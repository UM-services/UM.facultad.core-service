/**
 * 
 */
package ar.edu.um.facultad.rest.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "estalumno")
@NoArgsConstructor
@AllArgsConstructor
public class EstadoAlumno implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1002002551226888829L;

	@Id
	@Column(name = "idestado")
	private Integer estadoId;

	private String nombre;

	@Column(name = "esa_iniciales")
	private String iniciales;

}
