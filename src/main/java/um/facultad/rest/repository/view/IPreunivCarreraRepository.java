/**
 * 
 */
package um.facultad.rest.repository.view;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.facultad.rest.model.view.PreunivCarrera;

/**
 * @author daniel
 *
 */
@Repository
public interface IPreunivCarreraRepository extends JpaRepository<PreunivCarrera, Long> {

	public List<PreunivCarrera> findAllByFacultadIdAndLectivoIdAndGeograficaIdAndTurnoIdAndPlanIdAndCarreraId(
			Integer facultadId, Integer lectivoId, Integer geograficaId, Integer turnoId, Integer planId,
			Integer carreraId);

	public List<PreunivCarrera> findAllByFacultadIdAndLectivoId(Integer facultadId, Integer lectivoId);

}
