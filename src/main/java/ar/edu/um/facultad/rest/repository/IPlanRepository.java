/**
 * 
 */
package ar.edu.um.facultad.rest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.um.facultad.rest.model.Plan;

/**
 * @author daniel
 *
 */
@Repository
public interface IPlanRepository extends JpaRepository<Plan, Long> {

	public Optional<Plan> findByFacultadIdAndPlanId(Integer facultadId, Integer planId);

}
