/**
 * 
 */
package um.facultad.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import um.facultad.rest.exception.FacultadNotFoundException;
import um.facultad.rest.model.Facultad;
import um.facultad.rest.repository.IFacultadRepository;

/**
 * @author daniel
 *
 */
@Service
public class FacultadService {

	@Autowired
	private IFacultadRepository repository;

	public Facultad findByFacultadId(Integer facultadId) {
		return repository.findByFacultadId(facultadId).orElseThrow(() -> new FacultadNotFoundException(facultadId));
	}

}
