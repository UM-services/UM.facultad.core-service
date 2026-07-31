/**
 * 
 */
package um.facultad.rest.service;

import lombok.RequiredArgsConstructor;
import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import um.facultad.rest.exception.TituloEntregaException;
import um.facultad.rest.model.TituloEntregaEntity;
import um.facultad.rest.repository.TituloEntregaRepository;

/**
 * @author daniel
 *
 */
@Service
@RequiredArgsConstructor
public class TituloEntregaService {

	private final TituloEntregaRepository repository;

	public TituloEntregaEntity findByUnique(BigDecimal personaId, Integer documentoId, Integer facultadId, Integer planId,
                                            Integer carreraId) {
		return repository
				.findByPersonaIdAndDocumentoIdAndFacultadIdAndPlanIdAndCarreraId(personaId, documentoId, facultadId,
						planId, carreraId)
				.orElseThrow(() -> new TituloEntregaException(personaId, documentoId, facultadId, planId,
						carreraId));
	}

}
