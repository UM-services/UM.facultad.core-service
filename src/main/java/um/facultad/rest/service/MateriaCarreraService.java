/**
 * 
 */
package um.facultad.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import um.facultad.rest.model.MateriaCarrera;
import um.facultad.rest.repository.MateriaCarreraRepository;

/**
 * @author daniel
 *
 */
@Service
public class MateriaCarreraService {

	@Autowired
	private MateriaCarreraRepository repository;

	public List<MateriaCarrera> findAllByCarrera(Integer facultadId, Integer planId, Integer carreraId) {
		return repository.findAllByFacultadIdAndPlanIdAndCarreraId(facultadId, planId, carreraId);
	}

}
