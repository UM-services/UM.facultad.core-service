/**
 * 
 */
package um.facultad.rest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.facultad.rest.model.Plan;

/**
 * @author daniel
 *
 */
@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {

	public Optional<Plan> findByFacultadIdAndPlanId(Integer facultadId, Integer planId);

}
