/**
 * 
 */
package ar.edu.um.facultad.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.um.facultad.rest.exception.FacultadNotFoundException;
import ar.edu.um.facultad.rest.model.Facultad;
import ar.edu.um.facultad.rest.repository.IFacultadRepository;

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
