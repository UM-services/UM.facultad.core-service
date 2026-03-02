/**
 * 
 */
package um.facultad.rest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.facultad.rest.model.LectivoEntity;

/**
 * @author daniel
 *
 */
@Repository
public interface LectivoRepository extends JpaRepository<LectivoEntity, Integer> {

	public Optional<LectivoEntity> findByLectivoId(Integer lectivoId);

}
