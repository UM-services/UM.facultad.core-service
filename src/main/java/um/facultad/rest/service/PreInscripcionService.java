/**
 * 
 */
package um.facultad.rest.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import um.facultad.rest.exception.PreInscripcionException;
import um.facultad.rest.model.PreInscripcionEntity;
import um.facultad.rest.repository.PreInscripcionRepository;

/**
 * @author daniel
 *
 */
@Service
public class PreInscripcionService {

	@Autowired
	private PreInscripcionRepository repository;

	public List<PreInscripcionEntity> findAllByLectivo(Integer facultadId, Integer lectivoId) {
		return repository.findAllByFacultadIdAndLectivoId(facultadId, lectivoId);
	}

	public List<PreInscripcionEntity> findAllBySede(Integer facultadId, Integer lectivoId, Integer geograficaId) {
		return repository.findAllByFacultadIdAndLectivoIdAndGeograficaId(facultadId, lectivoId, geograficaId);
	}

	public List<PreInscripcionEntity> findAllByTurno(Integer facultadId, Integer lectivoId, Integer geograficaId,
                                                     Integer turnoId) {
		return repository.findAllByFacultadIdAndLectivoIdAndGeograficaIdAndTurnoId(facultadId, lectivoId, geograficaId,
				turnoId);
	}

	public PreInscripcionEntity findPersonaByLectivo(Integer facultadId, BigDecimal personaId, Integer documentoId,
                                                     Integer lectivoId) {
		return repository
				.findByFacultadIdAndPersonaIdAndDocumentoIdAndLectivoId(facultadId, personaId, documentoId, lectivoId)
				.orElseThrow(() -> new PreInscripcionException(facultadId, personaId, documentoId, lectivoId));
	}

}
