/**
 * 
 */
package um.facultad.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import um.facultad.rest.exception.ProvinciaException;
import um.facultad.rest.model.Provincia;
import um.facultad.rest.repository.ProvinciaRepository;

/**
 * @author daniel
 *
 */
@Service
public class ProvinciaService {
	@Autowired
	private ProvinciaRepository repository;

	public Provincia findByUnique(Integer facultadId, Integer provinciaId) {
		return repository.findByFacultadIdAndProvinciaId(facultadId, provinciaId)
				.orElseThrow(() -> new ProvinciaException(facultadId, provinciaId));
	}
}
