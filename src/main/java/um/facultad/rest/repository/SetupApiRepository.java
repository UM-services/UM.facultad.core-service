/**
 * 
 */
package um.facultad.rest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.facultad.rest.model.SetupApiEntity;

/**
 * @author daniel
 *
 */
@Repository
public interface SetupApiRepository extends JpaRepository<SetupApiEntity, Long> {

	public Optional<SetupApiEntity> findTopByOrderBySetupId();

}
