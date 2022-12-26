/**
 * 
 */
package ar.edu.um.facultad.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.um.facultad.rest.exception.ProvinciaNotFoundException;
import ar.edu.um.facultad.rest.model.Provincia;
import ar.edu.um.facultad.rest.repository.IProvinciaRepository;

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
