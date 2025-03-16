/**
 * 
 */
package um.facultad.rest.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import um.facultad.rest.exception.BajaException;
import um.facultad.rest.model.Baja;
import um.facultad.rest.repository.BajaRepository;

/**
 * @author daniel
 *
 */
@Service
public class BajaService {

	@Autowired
	private BajaRepository repository;

	public Baja findByUnique(Integer facultadId, BigDecimal personaId, Integer documentoId, Integer lectivoId) {
		return repository.findByFacultadIdAndPersonaIdAndDocumentoIdAndLectivoId(facultadId, personaId, documentoId,
				lectivoId).orElseThrow(() -> new BajaException(facultadId, personaId, documentoId, lectivoId));
	}
}
