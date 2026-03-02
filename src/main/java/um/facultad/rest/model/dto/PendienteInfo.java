/**
 * 
 */
package um.facultad.rest.model.dto;

import java.io.Serializable;
import java.util.List;

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
	private static final long serialVersionUID = -2508210776345665100L;

	private FacultadEntity facultad;
	private LectivoEntity lectivo;
	private GeograficaEntity geografica;
	private DocumentoEntity documento;
	private PersonaEntity persona;
	private PlanEntity plan;
	private CarreraEntity carrera;
	private InscripcionEntity inscripcion;
	private List<InscripcionDetalleEntity> detalles;
	private List<MateriaEntity> materias;
	private List<MateriaCarreraEntity> materiascarrera;
	private List<MateriaCursoEntity> materiascurso;
	private List<RegularidadEntity> regularidades;
	private List<InscripcionEntity> inscripciones;

}
