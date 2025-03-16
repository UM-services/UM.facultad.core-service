/**
 * 
 */
package um.facultad.rest.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import um.facultad.rest.exception.NacimientoException;
import um.facultad.rest.model.Nacimiento;
import um.facultad.rest.repository.NacimientoRepository;

/**
 * @author daniel
 *
 */
@Service
public class NacimientoService {

	@Autowired
	private NacimientoRepository repository;

	public Nacimiento findByUnique(BigDecimal personaId, Integer documentoId) {
		return repository.findByPersonaIdAndDocumentoId(personaId, documentoId)
				.orElseThrow(() -> new NacimientoException(personaId, documentoId));
	}

}
