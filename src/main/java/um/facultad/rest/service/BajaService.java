/**
 * 
 */
package um.facultad.rest.service;

import lombok.RequiredArgsConstructor;
import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import um.facultad.rest.exception.BajaException;
import um.facultad.rest.model.BajaEntity;
import um.facultad.rest.repository.BajaRepository;

/**
 * @author daniel
 *
 */
@Service
@RequiredArgsConstructor
public class BajaService {

	private final BajaRepository repository;

	public BajaEntity findByUnique(Integer facultadId, BigDecimal personaId, Integer documentoId, Integer lectivoId) {
		return repository.findByFacultadIdAndPersonaIdAndDocumentoIdAndLectivoId(facultadId, personaId, documentoId,
				lectivoId).orElseThrow(() -> new BajaException(facultadId, personaId, documentoId, lectivoId));
	}
}
