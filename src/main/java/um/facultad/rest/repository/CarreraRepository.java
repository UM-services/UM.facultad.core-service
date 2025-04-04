/**
 * 
 */
package um.facultad.rest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.facultad.rest.model.Carrera;

/**
 * @author daniel
 *
 */
@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Long> {

	public Optional<Carrera> findByFacultadIdAndPlanIdAndCarreraId(Integer facultadId, Integer planId,
			Integer carreraId);

}
