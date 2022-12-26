/**
 * 
 */
package ar.edu.um.facultad.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.um.facultad.rest.exception.MateriaNotFoundException;
import ar.edu.um.facultad.rest.model.Materia;
import ar.edu.um.facultad.rest.repository.IMateriaRepository;

/**
 * @author daniel
 *
 */
@Service
public class MateriaService {

	@Autowired
	private IMateriaRepository repository;

	public List<Materia> findAllByPlan(Integer facultadId, Integer planId) {
		return repository.findAllByFacultadIdAndPlanId(facultadId, planId);
	}

	public Materia findByUnique(Integer facultadId, Integer planId, String materiaId) {
		return repository.findByFacultadIdAndPlanIdAndMateriaId(facultadId, planId, materiaId)
				.orElseThrow(() -> new MateriaNotFoundException(facultadId, planId, materiaId));
	}

}
