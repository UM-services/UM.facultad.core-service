/**
 * 
 */
package um.facultad.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import um.facultad.rest.exception.DivisionException;
import um.facultad.rest.model.Division;
import um.facultad.rest.repository.DivisionRepository;

/**
 * @author daniel
 *
 */
@Service
public class DivisionService {

	@Autowired
	private DivisionRepository repository;

	public Division findByUnique(Integer facultadId, Integer divisionId) {
		return repository.findByFacultadIdAndDivisionId(facultadId, divisionId)
				.orElseThrow(() -> new DivisionException(facultadId, divisionId));
	}

}
