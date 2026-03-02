/**
 * 
 */
package um.facultad.rest.service.facade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import um.facultad.rest.exception.LegajoException;
import um.facultad.rest.model.*;
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
@RequiredArgsConstructor
public class AutoMatriculaService {

	private final PreInscripcionService preinscripcionservice;
	private final LegajoService legajoservice;
	private final InscripcionService inscripcionservice;
	private final MateriaCursoService materiacursoservice;
	private final InscripcionDetalleService inscripciondetalleservice;

	@Transactional
	public List<InscripcionEntity> auto_matricula_pre(Integer facultadId, Integer lectivoId, Integer geograficaId,
                                                      Integer turnoId) {
		List<InscripcionEntity> inscriptos = new ArrayList<InscripcionEntity>();
		Map<BigDecimal, InscripcionEntity> oldies = inscripcionservice.findAllByLectivo(facultadId, lectivoId).stream()
				.collect(Collectors.toMap(InscripcionEntity::getPersonaId, inscripcion -> inscripcion));
		List<InscripcionDetalleEntity> materias = new ArrayList<InscripcionDetalleEntity>();
		// Por cada alumno del pre genera una matrícula a 1er año
		for (PreInscripcionEntity preinscripcion : preinscripcionservice.findAllByTurno(facultadId, lectivoId, geograficaId,
				turnoId)) {
			LegajoEntity legajo = null;
			try {
				legajo = legajoservice.findByPersona(preinscripcion.getPersonaId(), preinscripcion.getDocumentoId(),
						facultadId);
			} catch (LegajoException e) {
				legajo = new LegajoEntity();
			}
			Long inscripcionId = null;
			if (oldies.containsKey(preinscripcion.getPersonaId())) {
				inscripcionId = oldies.get(preinscripcion.getPersonaId()).getInscripcionId();
			}
			inscriptos.add(new InscripcionEntity(preinscripcion.getFacultadId(), preinscripcion.getPersonaId(),
					preinscripcion.getDocumentoId(), lectivoId, inscripcionId, Tool.dateAbsoluteArgentina(), "", "", 0L,
					1, legajo.getPlanId(), legajo.getCarreraId(), preinscripcion.getGeograficaId(), (byte) 0, (byte) 0,
					1989 + lectivoId, (byte) 0, (byte) 0, 0, "Automatricula", 0, 0, 0, (byte) 0));
			// Buscar y registrar las materias de 1er año
			Map<String, InscripcionDetalleEntity> detalles = inscripciondetalleservice
					.findAllByPersona(preinscripcion.getPersonaId(), preinscripcion.getDocumentoId(), facultadId,
							lectivoId)
					.stream().collect(Collectors.toMap(InscripcionDetalleEntity::getMateriaId, detalle -> detalle));
			for (MateriaCursoEntity materiacurso : materiacursoservice.findAllByCurso(preinscripcion.getFacultadId(),
					legajo.getPlanId(), legajo.getCarreraId(), 1)) {
				Long inscripciondetalleId = null;
				if (detalles.containsKey(materiacurso.getMateriaId()))
					inscripciondetalleId = detalles.get(materiacurso.getMateriaId()).getInscripciondetalleId();
				materias.add(new InscripcionDetalleEntity(preinscripcion.getPersonaId(), preinscripcion.getDocumentoId(),
						lectivoId, facultadId, materiacurso.getPlanId(), materiacurso.getMateriaId(),
						inscripciondetalleId, materiacurso.getCurso(), materiacurso.getPeriodo(), 0, (byte) 0, (byte) 0,
						(byte) 0, (byte) 0, (byte) 0, null));
			}
		}
		inscriptos = inscripcionservice.saveAll(inscriptos);
		materias = inscripciondetalleservice.saveAll(materias);
		return inscriptos;
	}

}
