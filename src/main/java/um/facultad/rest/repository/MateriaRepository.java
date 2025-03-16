/**
 * 
 */
package um.facultad.rest.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.facultad.rest.model.Materia;

/**
 * @author daniel
 *
 */
@Repository
public interface MateriaRepository extends JpaRepository<Materia, Long> {

	public List<Materia> findAllByFacultadIdAndPlanId(Integer facultadId, Integer planId);

	public Optional<Materia> findByFacultadIdAndPlanIdAndMateriaId(Integer facultadId, Integer planId,
			String materiaId);

}
