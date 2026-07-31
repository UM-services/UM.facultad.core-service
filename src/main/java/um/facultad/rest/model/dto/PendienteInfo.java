/**
 * 
 */
package um.facultad.rest.model.dto;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import um.facultad.rest.hexagonal.carreras.carrera.domain.model.Carrera;
import um.facultad.rest.hexagonal.carreras.materia.domain.model.Materia;
import um.facultad.rest.hexagonal.carreras.plan.domain.model.Plan;
import um.facultad.rest.hexagonal.inscripciones.inscripcion.domain.model.Inscripcion;
import um.facultad.rest.hexagonal.inscripciones.inscripcionDetalle.domain.model.InscripcionDetalle;
import um.facultad.rest.hexagonal.personas.persona.domain.model.Persona;
import um.facultad.rest.model.*;
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
	@Serial
    private static final long serialVersionUID = -2508210776345665100L;

	private FacultadEntity facultad;
	private LectivoEntity lectivo;
	private GeograficaEntity geografica;
	private DocumentoEntity documento;
	private Persona persona;
	private Plan plan;
	private Carrera carrera;
	private Inscripcion inscripcion;
	private List<InscripcionDetalle> detalles;
	private List<Materia> materias;
	private List<MateriaCarreraEntity> materiascarrera;
	private List<MateriaCursoEntity> materiascurso;
	private List<RegularidadEntity> regularidades;
	private List<Inscripcion> inscripciones;

}
