/**
 * 
 */
package ar.edu.um.facultad.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.um.facultad.rest.model.MateriaCurso;

/**
 * @author daniel
 *
 */
@Repository
public interface IMateriaCursoRepository extends JpaRepository<MateriaCurso, Long> {

	public List<MateriaCurso> findAllByFacultadIdAndPlanIdAndCarreraIdAndCurso(Integer facultadId, Integer planId,
			Integer carreraId, Integer curso);

	public List<MateriaCurso> findAllByFacultadIdAndPlanIdAndCarreraId(Integer facultadId, Integer planId,
			Integer carreraId);

}
