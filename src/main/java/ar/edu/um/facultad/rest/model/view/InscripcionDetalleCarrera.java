/**
 * 
 */
package ar.edu.um.facultad.rest.model.view;

import java.io.Serializable;

import org.hibernate.annotations.Immutable;

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
@Immutable
@Table(name = "vw_inscripcion_detalle_carrera")
@NoArgsConstructor
@AllArgsConstructor
public class InscripcionDetalleCarrera implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -6352421576314258903L;

	@Id
	private String unified;

	private Integer facultadId;
	private Integer lectivoId;
	private Integer geograficaId;
	private Integer planId;
	private Integer carreraId;
	private String materiaId;
	private Integer cantidad = 0;

}
