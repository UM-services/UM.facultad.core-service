/**
 * 
 */
package ar.edu.um.facultad.rest.model.dto;

import java.io.Serializable;
import java.util.List;

import ar.edu.um.facultad.rest.model.Carrera;
import ar.edu.um.facultad.rest.model.Documento;
import ar.edu.um.facultad.rest.model.Facultad;
import ar.edu.um.facultad.rest.model.Geografica;
import ar.edu.um.facultad.rest.model.Inscripcion;
import ar.edu.um.facultad.rest.model.InscripcionDetalle;
import ar.edu.um.facultad.rest.model.Lectivo;
import ar.edu.um.facultad.rest.model.Materia;
import ar.edu.um.facultad.rest.model.MateriaCarrera;
import ar.edu.um.facultad.rest.model.MateriaCurso;
import ar.edu.um.facultad.rest.model.Persona;
import ar.edu.um.facultad.rest.model.Plan;
import ar.edu.um.facultad.rest.model.Regularidad;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author daniel
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PendienteInfo implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -2508210776345665100L;

	private Facultad facultad;
	private Lectivo lectivo;
	private Geografica geografica;
	private Documento documento;
	private Persona persona;
	private Plan plan;
	private Carrera carrera;
	private Inscripcion inscripcion;
	private List<InscripcionDetalle> detalles;
	private List<Materia> materias;
	private List<MateriaCarrera> materiascarrera;
	private List<MateriaCurso> materiascurso;
	private List<Regularidad> regularidades;
	private List<Inscripcion> inscripciones;

}
