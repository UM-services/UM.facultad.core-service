/**
 * 
 */
package ar.edu.um.facultad.rest.repository.view;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.um.facultad.rest.model.view.InscriptoMateria;

/**
 * @author daniel
 *
 */
@Repository
public interface IInscriptoMateriaRepository extends JpaRepository<InscriptoMateria, Long> {

	public List<InscriptoMateria> findAllByFacultadIdAndLectivoIdAndPlanIdAndMateriaIdAndCursoIdAndPeriodoIdAndDivisionIdAndGeograficaId(
			Integer facultadId, Integer lectivoId, Integer planId, String materiaId, Integer cursoId, Integer periodoId,
			Integer divisionId, Integer geograficaId, Sort sort);

}
