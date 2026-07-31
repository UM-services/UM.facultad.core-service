/**
 * 
 */
package um.facultad.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import um.facultad.rest.exception.DivisionException;
import um.facultad.rest.model.DivisionEntity;
import um.facultad.rest.repository.DivisionRepository;

/**
 * @author daniel
 *
 */
@Service
@RequiredArgsConstructor
public class DivisionService {

	private final DivisionRepository repository;

	public DivisionEntity findByUnique(Integer facultadId, Integer divisionId) {
		return repository.findByFacultadIdAndDivisionId(facultadId, divisionId)
				.orElseThrow(() -> new DivisionException(facultadId, divisionId));
	}

}
