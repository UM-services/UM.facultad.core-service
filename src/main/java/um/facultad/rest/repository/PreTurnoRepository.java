/**
 * 
 */
package um.facultad.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.facultad.rest.model.PreTurnoEntity;

/**
 * @author daniel
 *
 */
@Repository
public interface PreTurnoRepository extends JpaRepository<PreTurnoEntity, Long> {

	public List<PreTurnoEntity> findAllByFacultadIdAndLectivoId(Integer facultadId, Integer lectivoId);

}
