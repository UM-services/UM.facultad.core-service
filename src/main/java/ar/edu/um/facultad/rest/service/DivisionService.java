/**
 * 
 */
package ar.edu.um.facultad.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.um.facultad.rest.exception.DivisionNotFoundException;
import ar.edu.um.facultad.rest.model.Division;
import ar.edu.um.facultad.rest.repository.IDivisionRepository;

/**
 * @author daniel
 *
 */
@Service
public class DivisionService {

	@Autowired
	private IDivisionRepository repository;

	public Division findByUnique(Integer facultadId, Integer divisionId) {
		return repository.findByFacultadIdAndDivisionId(facultadId, divisionId)
				.orElseThrow(() -> new DivisionNotFoundException(facultadId, divisionId));
	}

}
