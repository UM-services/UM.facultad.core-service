/**
 * 
 */
package ar.edu.um.facultad.rest.repository.view;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.um.facultad.rest.model.view.InscriptoCurso;

/**
 * @author daniel
 *
 */
@Repository
public interface IInscriptoCursoRepository extends JpaRepository<InscriptoCurso, String> {

	public List<InscriptoCurso> findAllByFacultadIdAndLectivoIdAndGeograficaId(Integer facultadId, Integer lectivoId,
			Integer geograficaId, Sort sort);

	public List<InscriptoCurso> findAllByFacultadIdAndLectivoIdAndGeograficaIdAndCurso(Integer facultadId,
			Integer lectivoId, Integer geograficaId, Integer curso);

	public List<InscriptoCurso> findAllByFacultadIdAndLectivoId(Integer facultadId, Integer lectivoId, Sort sort);

}
