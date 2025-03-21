/**
 * 
 */
package um.facultad.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import um.facultad.rest.exception.MateriaException;
import um.facultad.rest.model.Materia;
import um.facultad.rest.repository.MateriaRepository;

/**
 * @author daniel
 *
 */
@Service
public class MateriaService {

	@Autowired
	private MateriaRepository repository;

	public List<Materia> findAllByPlan(Integer facultadId, Integer planId) {
		return repository.findAllByFacultadIdAndPlanId(facultadId, planId);
	}

	public Materia findByUnique(Integer facultadId, Integer planId, String materiaId) {
		return repository.findByFacultadIdAndPlanIdAndMateriaId(facultadId, planId, materiaId)
				.orElseThrow(() -> new MateriaException(facultadId, planId, materiaId));
	}

}
