/**
 * 
 */
package um.facultad.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.facultad.rest.model.MateriaCursoEntity;

/**
 * @author daniel
 *
 */
@Repository
public interface MateriaCursoRepository extends JpaRepository<MateriaCursoEntity, Long> {

	public List<MateriaCursoEntity> findAllByFacultadIdAndPlanIdAndCarreraIdAndCurso(Integer facultadId, Integer planId,
                                                                                     Integer carreraId, Integer curso);

	public List<MateriaCursoEntity> findAllByFacultadIdAndPlanIdAndCarreraId(Integer facultadId, Integer planId,
                                                                             Integer carreraId);

}
