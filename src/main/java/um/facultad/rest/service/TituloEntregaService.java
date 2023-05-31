/**
 * 
 */
package um.facultad.rest.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import um.facultad.rest.exception.TituloEntregaNotFoundException;
import um.facultad.rest.model.TituloEntrega;
import um.facultad.rest.repository.ITituloEntregaRepository;

/**
 * @author daniel
 *
 */
@Service
public class TituloEntregaService {

	@Autowired
	private ITituloEntregaRepository repository;

	public TituloEntrega findByUnique(BigDecimal personaId, Integer documentoId, Integer facultadId, Integer planId,
			Integer carreraId) {
		return repository
				.findByPersonaIdAndDocumentoIdAndFacultadIdAndPlanIdAndCarreraId(personaId, documentoId, facultadId,
						planId, carreraId)
				.orElseThrow(() -> new TituloEntregaNotFoundException(personaId, documentoId, facultadId, planId,
						carreraId));
	}

}