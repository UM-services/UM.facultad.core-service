/**
 * 
 */
package um.facultad.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import um.facultad.rest.exception.GeograficaNotFoundException;
import um.facultad.rest.model.Geografica;
import um.facultad.rest.repository.IGeograficaRepository;

/**
 * @author daniel
 *
 */
@Service
public class GeograficaService {

	@Autowired
	private IGeograficaRepository repository;

	public Geografica findByGeograficaId(Integer geograficaId) {
		return repository.findByGeograficaId(geograficaId).orElseThrow(() -> new GeograficaNotFoundException(geograficaId));
	}

}
