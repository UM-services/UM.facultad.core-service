/**
 * 
 */
package um.facultad.rest.hexagonal.carreras.materia.infrastructure.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.facultad.rest.hexagonal.carreras.materia.infrastructure.persistence.entity.MateriaEntity;

/**
 * @author daniel
 *
 */
@Repository
public interface JpaMateriaRepository extends JpaRepository<MateriaEntity, Long> {

	public List<MateriaEntity> findAllByFacultadIdAndPlanId(Integer facultadId, Integer planId);

	public Optional<MateriaEntity> findByFacultadIdAndPlanIdAndMateriaId(Integer facultadId, Integer planId,
                                                                         String materiaId);

}
