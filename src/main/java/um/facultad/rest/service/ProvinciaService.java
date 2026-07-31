/**
 * 
 */
package um.facultad.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import um.facultad.rest.exception.ProvinciaException;
import um.facultad.rest.model.ProvinciaEntity;
import um.facultad.rest.repository.ProvinciaRepository;

/**
 * @author daniel
 *
 */
@Service
@RequiredArgsConstructor
public class ProvinciaService {
	private final ProvinciaRepository repository;

	public ProvinciaEntity findByUnique(Integer facultadId, Integer provinciaId) {
		return repository.findByFacultadIdAndProvinciaId(facultadId, provinciaId)
				.orElseThrow(() -> new ProvinciaException(facultadId, provinciaId));
	}
}
