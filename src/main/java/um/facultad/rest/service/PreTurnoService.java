/**
 * 
 */
package um.facultad.rest.service;

import lombok.RequiredArgsConstructor;
import java.util.List;

import org.springframework.stereotype.Service;

import um.facultad.rest.model.PreTurnoEntity;
import um.facultad.rest.repository.PreTurnoRepository;

/**
 * @author daniel
 *
 */
@Service
@RequiredArgsConstructor
public class PreTurnoService {

	private final PreTurnoRepository repository;

	public List<PreTurnoEntity> findAllByLectivo(Integer facultadId, Integer lectivoId) {
		return repository.findAllByFacultadIdAndLectivoId(facultadId, lectivoId);
	}

}
