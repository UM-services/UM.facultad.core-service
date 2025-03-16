/**
 * 
 */
package um.facultad.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import um.facultad.rest.exception.FacultadException;
import um.facultad.rest.model.Facultad;
import um.facultad.rest.repository.FacultadRepository;

/**
 * @author daniel
 *
 */
@Service
public class FacultadService {

	@Autowired
	private FacultadRepository repository;

	public Facultad findByFacultadId(Integer facultadId) {
		return repository.findByFacultadId(facultadId).orElseThrow(() -> new FacultadException(facultadId));
	}

}
