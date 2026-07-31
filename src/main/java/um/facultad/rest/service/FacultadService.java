/**
 * 
 */
package um.facultad.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import um.facultad.rest.exception.FacultadException;
import um.facultad.rest.model.FacultadEntity;
import um.facultad.rest.repository.FacultadRepository;

/**
 * @author daniel
 *
 */
@Service
@RequiredArgsConstructor
public class FacultadService {

	private final FacultadRepository repository;

	public FacultadEntity findByFacultadId(Integer facultadId) {
		return repository.findByFacultadId(facultadId).orElseThrow(() -> new FacultadException(facultadId));
	}

}
