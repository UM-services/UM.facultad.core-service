/**
 * 
 */
package ar.edu.um.facultad.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.um.facultad.rest.model.MateriaCarrera;
import ar.edu.um.facultad.rest.repository.IMateriaCarreraRepository;

/**
 * @author daniel
 *
 */
@Service
public class MateriaCarreraService {

	@Autowired
	private IMateriaCarreraRepository repository;

	public List<MateriaCarrera> findAllByCarrera(Integer facultadId, Integer planId, Integer carreraId) {
		return repository.findAllByFacultadIdAndPlanIdAndCarreraId(facultadId, planId, carreraId);
	}

}
