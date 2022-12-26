/**
 * 
 */
package ar.edu.um.facultad.rest.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.um.facultad.rest.exception.BajaNotFoundException;
import ar.edu.um.facultad.rest.model.Baja;
import ar.edu.um.facultad.rest.repository.IBajaRepository;

/**
 * @author daniel
 *
 */
@Service
public class BajaService {

	@Autowired
	private IBajaRepository repository;

	public Baja findByUnique(Integer facultadId, BigDecimal personaId, Integer documentoId, Integer lectivoId) {
		return repository.findByFacultadIdAndPersonaIdAndDocumentoIdAndLectivoId(facultadId, personaId, documentoId,
				lectivoId).orElseThrow(() -> new BajaNotFoundException(facultadId, personaId, documentoId, lectivoId));
	}
}
