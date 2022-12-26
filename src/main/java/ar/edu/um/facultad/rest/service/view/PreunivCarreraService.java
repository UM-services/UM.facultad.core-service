/**
 * 
 */
package ar.edu.um.facultad.rest.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.um.facultad.rest.model.view.PreunivCarrera;
import ar.edu.um.facultad.rest.repository.view.IPreunivCarreraRepository;

/**
 * @author daniel
 *
 */
@Service
public class PreunivCarreraService {

	@Autowired
	private IPreunivCarreraRepository repository;

	public List<PreunivCarrera> findAllByCarrera(Integer facultadId, Integer lectivoId, Integer geograficaId,
			Integer turnoId, Integer planId, Integer carreraId) {
		return repository.findAllByFacultadIdAndLectivoIdAndGeograficaIdAndTurnoIdAndPlanIdAndCarreraId(facultadId,
				lectivoId, geograficaId, turnoId, planId, carreraId);
	}

	public List<PreunivCarrera> findAllByLectivo(Integer facultadId, Integer lectivoId) {
		return repository.findAllByFacultadIdAndLectivoId(facultadId, lectivoId);
	}

}
