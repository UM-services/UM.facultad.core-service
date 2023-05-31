/**
 * 
 */
package um.facultad.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import um.facultad.rest.exception.CarreraNotFoundException;
import um.facultad.rest.model.Carrera;
import um.facultad.rest.repository.ICarreraRepository;

/**
 * @author daniel
 *
 */
@Service
public class CarreraService {

	@Autowired
	private ICarreraRepository repository;

	public List<Carrera> findAll() {
		return repository.findAll();
	}

	public Carrera findByUnique(Integer facultadId, Integer planId, Integer carreraId) {
		return repository.findByFacultadIdAndPlanIdAndCarreraId(facultadId, planId, carreraId).orElseThrow(() -> new CarreraNotFoundException(facultadId, planId, carreraId));
	}

}
