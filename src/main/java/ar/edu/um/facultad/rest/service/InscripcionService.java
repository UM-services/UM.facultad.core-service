/**
 * 
 */
package ar.edu.um.facultad.rest.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.um.facultad.rest.exception.InscripcionNotFoundException;
import ar.edu.um.facultad.rest.model.Inscripcion;
import ar.edu.um.facultad.rest.repository.IInscripcionRepository;

/**
 * @author daniel
 *
 */
@Service
public class InscripcionService {

	@Autowired
	private IInscripcionRepository repository;

	public List<Inscripcion> findAllByLectivo(Integer facultadId, Integer lectivoId) {
		return repository.findAllByFacultadIdAndLectivoId(facultadId, lectivoId);
	}

	public List<Inscripcion> findAllByCurso(Integer facultadId, Integer lectivoId, Integer geograficaId,
			Integer curso) {
		return repository.findAllByFacultadIdAndLectivoIdAndGeograficaIdAndCurso(facultadId, lectivoId, geograficaId,
				curso);
	}

	public List<Inscripcion> findAllByCursoSinProvisoria(Integer facultadId, Integer lectivoId, Integer geograficaId,
			Integer curso) {
		return repository.findAllByFacultadIdAndLectivoIdAndGeograficaIdAndCursoAndProvisoria(facultadId, lectivoId, geograficaId,
				curso, (byte) 0);
	}

	public List<Inscripcion> findAllAnteriores(BigDecimal personaId, Integer documentoId, Integer facultadId,
			Integer lectivoId) {
		return repository.findAllByPersonaIdAndDocumentoIdAndFacultadIdAndLectivoIdLessThanOrderByLectivoIdDesc(
				personaId, documentoId, facultadId, lectivoId);
	}

	public Inscripcion findByUnique(Integer facultadId, BigDecimal personaId, Integer documentoId, Integer lectivoId) {
		return repository
				.findByFacultadIdAndPersonaIdAndDocumentoIdAndLectivoId(facultadId, personaId, documentoId, lectivoId)
				.orElseThrow(() -> new InscripcionNotFoundException(facultadId, personaId, documentoId, lectivoId));
	}

	public List<Inscripcion> saveAll(List<Inscripcion> inscriptos) {
		return repository.saveAll(inscriptos);
	}

}
