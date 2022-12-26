/**
 * 
 */
package ar.edu.um.facultad.rest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.um.facultad.rest.model.SetupApi;

/**
 * @author daniel
 *
 */
@Repository
public interface ISetupApiRepository extends JpaRepository<SetupApi, Long> {

	public Optional<SetupApi> findTopByOrderBySetupId();

}
