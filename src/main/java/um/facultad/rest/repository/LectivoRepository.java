/**
 * 
 */
package um.facultad.rest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.facultad.rest.model.Lectivo;

/**
 * @author daniel
 *
 */
@Repository
public interface LectivoRepository extends JpaRepository<Lectivo, Integer> {

	public Optional<Lectivo> findByLectivoId(Integer lectivoId);

}
