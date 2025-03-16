/**
 * 
 */
package um.facultad.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import um.facultad.rest.model.PreTurno;
import um.facultad.rest.repository.PreTurnoRepository;

/**
 * @author daniel
 *
 */
@Service
public class PreTurnoService {

	@Autowired
	private PreTurnoRepository repository;

	public List<PreTurno> findAllByLectivo(Integer facultadId, Integer lectivoId) {
		return repository.findAllByFacultadIdAndLectivoId(facultadId, lectivoId);
	}

}
