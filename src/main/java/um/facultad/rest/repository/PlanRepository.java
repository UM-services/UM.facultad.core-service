/**
 * 
 */
package um.facultad.rest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.facultad.rest.model.PlanEntity;

/**
 * @author daniel
 *
 */
@Repository
public interface PlanRepository extends JpaRepository<PlanEntity, Long> {

	public Optional<PlanEntity> findByFacultadIdAndPlanId(Integer facultadId, Integer planId);

}
