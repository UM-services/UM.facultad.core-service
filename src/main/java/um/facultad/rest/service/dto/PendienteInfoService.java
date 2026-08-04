/**
 * 
 */
package um.facultad.rest.service.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Supplier;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
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
		info.setFacultad(load("facultad", () -> facultadservice.findByFacultadId(facultadId), facultadId,
				personaId, documentoId, null));
		info.setLectivo(load("lectivo", () -> lectivoservice.findByLectivoId(lectivoId), facultadId, personaId,
				documentoId, null));
		info.setGeografica(load("geografica", () -> geograficaservice.findByGeograficaId(geograficaId), facultadId,
				personaId, documentoId, null));
		info.setDocumento(load("documento", () -> documentoservice.findByDocumentoId(documentoId), facultadId,
				personaId, documentoId, null));
		info.setPersona(load("persona", () -> personaservice.findByPersonaIdAndDocumentoId(personaId, documentoId),
				facultadId, personaId, documentoId, null));

		Inscripcion inscripcion = load("inscripcion",
				() -> inscripcionservice.findByUnique(facultadId, personaId, documentoId, lectivoId), facultadId,
				personaId, documentoId, null);
		info.setInscripcion(inscripcion);
		info.setDetalles(load("detalles",
				() -> inscripciondetalleservice.findAllByPersona(personaId, documentoId, facultadId, lectivoId),
				facultadId, personaId, documentoId, List.of()));
		info.setInscripciones(load("inscripciones anteriores",
				() -> inscripcionservice.findAllAnteriores(personaId, documentoId, facultadId, lectivoId), facultadId,
				personaId, documentoId, List.of()));

		if (inscripcion == null) {
			info.setMaterias(List.of());
			info.setMateriascarrera(List.of());
			info.setMateriascurso(List.of());
			info.setRegularidades(List.of());
			return info;
		}

		Integer inscripcionFacultadId = inscripcion.getFacultadId();
		Integer planId = inscripcion.getPlanId();
		Integer carreraId = inscripcion.getCarreraId();
		info.setPlan(load("plan", () -> planservice.findByUnique(inscripcionFacultadId, planId), facultadId,
				personaId, documentoId, null));
		info.setCarrera(load("carrera", () -> carreraservice.findByUnique(inscripcionFacultadId, planId, carreraId),
				facultadId, personaId, documentoId, null));
		info.setMaterias(load("materias", () -> materiaservice.findAllByPlan(inscripcionFacultadId, planId), facultadId,
				personaId, documentoId, List.of()));
		List<MateriaCarreraEntity> materiasCarrera = load("materias carrera",
				() -> materiacarreraservice.findAllByCarrera(inscripcionFacultadId, planId, carreraId), facultadId,
				personaId, documentoId, List.of());
		info.setMateriascarrera(materiasCarrera);
		info.setMateriascurso(load("materias curso",
				() -> materiacursoservice.findAllByCarrera(inscripcionFacultadId, planId, carreraId), facultadId,
				personaId, documentoId, List.of()));
		info.setRegularidades(load("regularidades",
				() -> regularidadservice.findAllByMaterias(personaId, documentoId, inscripcionFacultadId, planId,
						materiasCarrera.stream().map(MateriaCarreraEntity::getMateriaId).toList()),
				facultadId, personaId, documentoId, List.of()));
		return info;
	}

	private <T> T load(String section, Supplier<T> supplier, Integer facultadId, BigDecimal personaId,
			Integer documentoId, T fallback) {
		try {
			T value = supplier.get();
			return value == null ? fallback : value;
		} catch (RuntimeException exception) {
			log.warn("No se pudo cargar la sección {} para facultad={}, persona={}, documento={}: {}", section, facultadId,
					personaId, documentoId, exception.getMessage());
			return fallback;
		}
	}

}
