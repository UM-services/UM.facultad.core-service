/**
 * 
 */
package um.facultad.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import um.facultad.rest.exception.PlanException;
import um.facultad.rest.model.PlanEntity;
import um.facultad.rest.repository.PlanRepository;

/**
 * @author daniel
 *
 */
@Service
public class PlanService {

	@Autowired
	private PlanRepository repository;

	public List<PlanEntity> findAll() {
		return repository.findAll();
	}

	public PlanEntity findByUnique(Integer facultadId, Integer planId) {
		return repository.findByFacultadIdAndPlanId(facultadId, planId)
				.orElseThrow(() -> new PlanException(facultadId, planId));
	}

}
