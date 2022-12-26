/**
 * 
 */
package ar.edu.um.facultad.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.um.facultad.rest.exception.PlanNotFoundException;
import ar.edu.um.facultad.rest.model.Plan;
import ar.edu.um.facultad.rest.repository.IPlanRepository;

/**
 * @author daniel
 *
 */
@Service
public class PlanService {

	@Autowired
	private IPlanRepository repository;

	public List<Plan> findAll() {
		return repository.findAll();
	}

	public Plan findByUnique(Integer facultadId, Integer planId) {
		return repository.findByFacultadIdAndPlanId(facultadId, planId)
				.orElseThrow(() -> new PlanNotFoundException(facultadId, planId));
	}

}
