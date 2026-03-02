/**
 * 
 */
package um.facultad.rest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.facultad.rest.model.CarreraEntity;

/**
 * @author daniel
 *
 */
@Repository
public interface CarreraRepository extends JpaRepository<CarreraEntity, Long> {

	Optional<CarreraEntity> findByFacultadIdAndPlanIdAndCarreraId(Integer facultadId, Integer planId,
                                                                         Integer carreraId);

}
