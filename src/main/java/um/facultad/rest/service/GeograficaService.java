/**
 * 
 */
package um.facultad.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import um.facultad.rest.exception.GeograficaException;
import um.facultad.rest.model.GeograficaEntity;
import um.facultad.rest.repository.GeograficaRepository;

/**
 * @author daniel
 *
 */
@Service
@RequiredArgsConstructor
public class GeograficaService {

	private final GeograficaRepository repository;

	public GeograficaEntity findByGeograficaId(Integer geograficaId) {
		return repository.findByGeograficaId(geograficaId).orElseThrow(() -> new GeograficaException(geograficaId));
	}

}
