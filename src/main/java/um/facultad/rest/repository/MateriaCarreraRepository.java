/**
 * 
 */
package um.facultad.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.facultad.rest.model.MateriaCarrera;

/**
 * @author daniel
 *
 */
@Repository
public interface MateriaCarreraRepository extends JpaRepository<MateriaCarrera, Long> {

	public List<MateriaCarrera> findAllByFacultadIdAndPlanIdAndCarreraId(Integer facultadId, Integer planId,
			Integer carreraId);

}
