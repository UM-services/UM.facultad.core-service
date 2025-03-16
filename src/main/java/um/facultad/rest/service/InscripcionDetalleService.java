/**
 * 
 */
package um.facultad.rest.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import um.facultad.rest.model.InscripcionDetalle;
import um.facultad.rest.repository.InscripcionDetalleRepository;

/**
 * @author daniel
 *
 */
@Service
public class InscripcionDetalleService {

	@Autowired
	private InscripcionDetalleRepository repository;

	public List<InscripcionDetalle> findAllByPersona(BigDecimal personaId, Integer documentoId, Integer facultadId,
			Integer lectivoId) {
		return repository.findAllByPersonaIdAndDocumentoIdAndFacultadIdAndLectivoId(personaId, documentoId, facultadId,
				lectivoId);
	}

	public List<InscripcionDetalle> saveAll(List<InscripcionDetalle> materias) {
		return repository.saveAll(materias);
	}

}
