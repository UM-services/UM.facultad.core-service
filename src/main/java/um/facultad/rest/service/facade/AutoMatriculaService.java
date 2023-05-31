/**
 * 
 */
package um.facultad.rest.service.facade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import um.facultad.rest.kotlin.model.Legajo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import um.facultad.rest.exception.LegajoNotFoundException;
import um.facultad.rest.model.Inscripcion;
import um.facultad.rest.model.InscripcionDetalle;
import um.facultad.rest.model.MateriaCurso;
import um.facultad.rest.model.PreInscripcion;
import um.facultad.rest.service.InscripcionDetalleService;
import um.facultad.rest.service.InscripcionService;
import um.facultad.rest.service.LegajoService;
import um.facultad.rest.service.MateriaCursoService;
import um.facultad.rest.service.PreInscripcionService;
import um.facultad.rest.util.Tool;
import jakarta.transaction.Transactional;

/**
 * @author daniel
 *
 */
@Service
public class AutoMatriculaService {

	@Autowired
	private PreInscripcionService preinscripcionservice;

	@Autowired
	private LegajoService legajoservice;

	@Autowired
	private InscripcionService inscripcionservice;

	@Autowired
	private MateriaCursoService materiacursoservice;

	@Autowired
	private InscripcionDetalleService inscripciondetalleservice;

	@Transactional
	public List<Inscripcion> auto_matricula_pre(Integer facultadId, Integer lectivoId, Integer geograficaId,
                                                Integer turnoId) {
		List<Inscripcion> inscriptos = new ArrayList<Inscripcion>();
		Map<BigDecimal, Inscripcion> oldies = inscripcionservice.findAllByLectivo(facultadId, lectivoId).stream()
				.collect(Collectors.toMap(Inscripcion::getPersonaId, inscripcion -> inscripcion));
		List<InscripcionDetalle> materias = new ArrayList<InscripcionDetalle>();
		// Por cada alumno del pre genera una matrícula a 1er año
		for (PreInscripcion preinscripcion : preinscripcionservice.findAllByTurno(facultadId, lectivoId, geograficaId,
				turnoId)) {
			Legajo legajo = null;
			try {
				legajo = legajoservice.findByPersona(preinscripcion.getPersonaId(), preinscripcion.getDocumentoId(),
						facultadId);
			} catch (LegajoNotFoundException e) {
				legajo = new Legajo();
			}
			Long inscripcionId = null;
			if (oldies.containsKey(preinscripcion.getPersonaId())) {
				inscripcionId = oldies.get(preinscripcion.getPersonaId()).getInscripcionId();
			}
			inscriptos.add(new Inscripcion(preinscripcion.getFacultadId(), preinscripcion.getPersonaId(),
					preinscripcion.getDocumentoId(), lectivoId, inscripcionId, Tool.dateAbsoluteArgentina(), "", "", 0L,
					1, legajo.getPlanId(), legajo.getCarreraId(), preinscripcion.getGeograficaId(), (byte) 0, (byte) 0,
					1989 + lectivoId, (byte) 0, (byte) 0, 0, "Automatricula", 0, 0, 0, (byte) 0));
			// Buscar y registrar las materias de 1er año
			Map<String, InscripcionDetalle> detalles = inscripciondetalleservice
					.findAllByPersona(preinscripcion.getPersonaId(), preinscripcion.getDocumentoId(), facultadId,
							lectivoId)
					.stream().collect(Collectors.toMap(InscripcionDetalle::getMateriaId, detalle -> detalle));
			for (MateriaCurso materiacurso : materiacursoservice.findAllByCurso(preinscripcion.getFacultadId(),
					legajo.getPlanId(), legajo.getCarreraId(), 1)) {
				Long inscripciondetalleId = null;
				if (detalles.containsKey(materiacurso.getMateriaId()))
					inscripciondetalleId = detalles.get(materiacurso.getMateriaId()).getInscripciondetalleId();
				materias.add(new InscripcionDetalle(preinscripcion.getPersonaId(), preinscripcion.getDocumentoId(),
						lectivoId, facultadId, materiacurso.getPlanId(), materiacurso.getMateriaId(),
						inscripciondetalleId, materiacurso.getCurso(), materiacurso.getPeriodo(), 0, (byte) 0, (byte) 0,
						(byte) 0, (byte) 0, (byte) 0));
			}
		}
		inscriptos = inscripcionservice.saveAll(inscriptos);
		materias = inscripciondetalleservice.saveAll(materias);
		return inscriptos;
	}

}
