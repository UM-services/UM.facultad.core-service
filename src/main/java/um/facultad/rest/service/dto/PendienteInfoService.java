/**
 * 
 */
package um.facultad.rest.service.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import um.facultad.rest.hexagonal.inscripciones.inscripcion.domain.model.Inscripcion;
import um.facultad.rest.model.MateriaCarreraEntity;
import um.facultad.rest.model.dto.PendienteInfo;
import um.facultad.rest.hexagonal.carreras.carrera.application.service.CarreraService;
import um.facultad.rest.service.DocumentoService;
import um.facultad.rest.service.FacultadService;
import um.facultad.rest.service.GeograficaService;
import um.facultad.rest.hexagonal.inscripciones.inscripcionDetalle.application.service.InscripcionDetalleService;
import um.facultad.rest.hexagonal.inscripciones.inscripcion.application.service.InscripcionService;
import um.facultad.rest.service.LectivoService;
import um.facultad.rest.service.MateriaCarreraService;
import um.facultad.rest.service.MateriaCursoService;
import um.facultad.rest.hexagonal.carreras.materia.application.service.MateriaService;
import um.facultad.rest.hexagonal.personas.persona.application.service.PersonaService;
import um.facultad.rest.hexagonal.carreras.plan.application.service.PlanService;
import um.facultad.rest.service.RegularidadService;

/**
 * @author daniel
 *
 */
@Service
@RequiredArgsConstructor
public class PendienteInfoService {

	private final FacultadService facultadservice;
	private final LectivoService lectivoservice;
	private final GeograficaService geograficaservice;
	private final DocumentoService documentoservice;
	private final PersonaService personaservice;
	private final InscripcionService inscripcionservice;
	private final PlanService planservice;
	private final CarreraService carreraservice;
	private final InscripcionDetalleService inscripciondetalleservice;
	private final MateriaService materiaservice;
	private final MateriaCarreraService materiacarreraservice;
	private final MateriaCursoService materiacursoservice;
	private final RegularidadService regularidadservice;

	public PendienteInfo findByAlumno(Integer facultadId, Integer lectivoId, Integer geograficaId, BigDecimal personaId,
			Integer documentoId) {
		PendienteInfo info = new PendienteInfo();
		info.setFacultad(facultadservice.findByFacultadId(facultadId));
		info.setLectivo(lectivoservice.findByLectivoId(lectivoId));
		info.setGeografica(geograficaservice.findByGeograficaId(geograficaId));
		info.setDocumento(documentoservice.findByDocumentoId(documentoId));
		info.setPersona(personaservice.findByPersonaIdAndDocumentoId(personaId, documentoId));
		Inscripcion inscripcion = null;
		info.setInscripcion(
				inscripcion = inscripcionservice.findByUnique(facultadId, personaId, documentoId, lectivoId));
		info.setPlan(planservice.findByUnique(inscripcion.getFacultadId(), inscripcion.getPlanId()));
		info.setCarrera(carreraservice.findByUnique(inscripcion.getFacultadId(), inscripcion.getPlanId(),
				inscripcion.getCarreraId()));
		info.setDetalles(inscripciondetalleservice.findAllByPersona(personaId, documentoId, facultadId, lectivoId));
		info.setMaterias(materiaservice.findAllByPlan(inscripcion.getFacultadId(), inscripcion.getPlanId()));
		List<MateriaCarreraEntity> materias = null;
		info.setMateriascarrera(materias = materiacarreraservice.findAllByCarrera(inscripcion.getFacultadId(),
				inscripcion.getPlanId(), inscripcion.getCarreraId()));
		info.setMateriascurso(materiacursoservice.findAllByCarrera(inscripcion.getFacultadId(), inscripcion.getPlanId(),
				inscripcion.getCarreraId()));
		info.setRegularidades(regularidadservice.findAllByMaterias(personaId, documentoId, inscripcion.getFacultadId(),
				inscripcion.getPlanId(),
				materias.stream().map(MateriaCarreraEntity::getMateriaId).collect(Collectors.toList())));
		info.setInscripciones(inscripcionservice.findAllAnteriores(personaId, documentoId, facultadId, lectivoId));
		return info;
	}

}
