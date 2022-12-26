/**
 * 
 */
package ar.edu.um.facultad.rest.service.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.um.facultad.rest.model.Inscripcion;
import ar.edu.um.facultad.rest.model.MateriaCarrera;
import ar.edu.um.facultad.rest.model.dto.PendienteInfo;
import ar.edu.um.facultad.rest.service.CarreraService;
import ar.edu.um.facultad.rest.service.DocumentoService;
import ar.edu.um.facultad.rest.service.FacultadService;
import ar.edu.um.facultad.rest.service.GeograficaService;
import ar.edu.um.facultad.rest.service.InscripcionDetalleService;
import ar.edu.um.facultad.rest.service.InscripcionService;
import ar.edu.um.facultad.rest.service.LectivoService;
import ar.edu.um.facultad.rest.service.MateriaCarreraService;
import ar.edu.um.facultad.rest.service.MateriaCursoService;
import ar.edu.um.facultad.rest.service.MateriaService;
import ar.edu.um.facultad.rest.service.PersonaService;
import ar.edu.um.facultad.rest.service.PlanService;
import ar.edu.um.facultad.rest.service.RegularidadService;

/**
 * @author daniel
 *
 */
@Service
public class PendienteInfoService {

	@Autowired
	private FacultadService facultadservice;

	@Autowired
	private LectivoService lectivoservice;

	@Autowired
	private GeograficaService geograficaservice;

	@Autowired
	private DocumentoService documentoservice;

	@Autowired
	private PersonaService personaservice;

	@Autowired
	private InscripcionService inscripcionservice;

	@Autowired
	private PlanService planservice;

	@Autowired
	private CarreraService carreraservice;

	@Autowired
	private InscripcionDetalleService inscripciondetalleservice;

	@Autowired
	private MateriaService materiaservice;

	@Autowired
	private MateriaCarreraService materiacarreraservice;

	@Autowired
	private MateriaCursoService materiacursoservice;

	@Autowired
	private RegularidadService regularidadservice;

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
		List<MateriaCarrera> materias = null;
		info.setMateriascarrera(materias = materiacarreraservice.findAllByCarrera(inscripcion.getFacultadId(),
				inscripcion.getPlanId(), inscripcion.getCarreraId()));
		info.setMateriascurso(materiacursoservice.findAllByCarrera(inscripcion.getFacultadId(), inscripcion.getPlanId(),
				inscripcion.getCarreraId()));
		info.setRegularidades(regularidadservice.findAllByMaterias(personaId, documentoId, inscripcion.getFacultadId(),
				inscripcion.getPlanId(),
				materias.stream().map(materia -> materia.getMateriaId()).collect(Collectors.toList())));
		info.setInscripciones(inscripcionservice.findAllAnteriores(personaId, documentoId, facultadId, lectivoId));
		return info;
	}

}
