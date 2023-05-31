/**
 * 
 */
package um.facultad.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import um.facultad.rest.exception.ProvinciaNotFoundException;
import um.facultad.rest.model.Provincia;
import um.facultad.rest.repository.IProvinciaRepository;

/**
 * @author daniel
 *
 */
@Service
public class ProvinciaService {
	@Autowired
	private IProvinciaRepository repository;

	public Provincia findByUnique(Integer facultadId, Integer provinciaId) {
		return repository.findByFacultadIdAndProvinciaId(facultadId, provinciaId)
				.orElseThrow(() -> new ProvinciaNotFoundException(facultadId, provinciaId));
	}
}
