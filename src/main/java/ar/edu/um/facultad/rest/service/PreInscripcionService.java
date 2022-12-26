/**
 * 
 */
package ar.edu.um.facultad.rest.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.um.facultad.rest.exception.PreInscripcionNotFoundException;
import ar.edu.um.facultad.rest.model.PreInscripcion;
import ar.edu.um.facultad.rest.repository.IPreInscripcionRepository;

/**
 * @author daniel
 *
 */
@Service
public class PreInscripcionService {

	@Autowired
	private IPreInscripcionRepository repository;

	public List<PreInscripcion> findAllByLectivo(Integer facultadId, Integer lectivoId) {
		return repository.findAllByFacultadIdAndLectivoId(facultadId, lectivoId);
	}

	public List<PreInscripcion> findAllBySede(Integer facultadId, Integer lectivoId, Integer geograficaId) {
		return repository.findAllByFacultadIdAndLectivoIdAndGeograficaId(facultadId, lectivoId, geograficaId);
	}

	public List<PreInscripcion> findAllByTurno(Integer facultadId, Integer lectivoId, Integer geograficaId,
			Integer turnoId) {
		return repository.findAllByFacultadIdAndLectivoIdAndGeograficaIdAndTurnoId(facultadId, lectivoId, geograficaId,
				turnoId);
	}

	public PreInscripcion findPersonaByLectivo(Integer facultadId, BigDecimal personaId, Integer documentoId,
			Integer lectivoId) {
		return repository
				.findByFacultadIdAndPersonaIdAndDocumentoIdAndLectivoId(facultadId, personaId, documentoId, lectivoId)
				.orElseThrow(() -> new PreInscripcionNotFoundException(facultadId, personaId, documentoId, lectivoId));
	}

}
