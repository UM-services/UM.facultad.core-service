/**
 * 
 */
package ar.edu.um.facultad.rest.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.um.facultad.rest.exception.NacimientoNotFoundException;
import ar.edu.um.facultad.rest.model.Nacimiento;
import ar.edu.um.facultad.rest.repository.INacimientoRepository;

/**
 * @author daniel
 *
 */
@Service
public class NacimientoService {

	@Autowired
	private INacimientoRepository repository;

	public Nacimiento findByUnique(BigDecimal personaId, Integer documentoId) {
		return repository.findByPersonaIdAndDocumentoId(personaId, documentoId)
				.orElseThrow(() -> new NacimientoNotFoundException(personaId, documentoId));
	}

}
