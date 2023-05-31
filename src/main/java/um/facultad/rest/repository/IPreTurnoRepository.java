/**
 * 
 */
package um.facultad.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.facultad.rest.model.PreTurno;

/**
 * @author daniel
 *
 */
@Repository
public interface IPreTurnoRepository extends JpaRepository<PreTurno, Long> {

	public List<PreTurno> findAllByFacultadIdAndLectivoId(Integer facultadId, Integer lectivoId);

}
