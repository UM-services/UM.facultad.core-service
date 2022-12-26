/**
 * 
 */
package ar.edu.um.facultad.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.um.facultad.rest.model.PreTurno;
import ar.edu.um.facultad.rest.repository.IPreTurnoRepository;

/**
 * @author daniel
 *
 */
@Service
public class PreTurnoService {

	@Autowired
	private IPreTurnoRepository repository;

	public List<PreTurno> findAllByLectivo(Integer facultadId, Integer lectivoId) {
		return repository.findAllByFacultadIdAndLectivoId(facultadId, lectivoId);
	}

}
